package lab11;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class SimpleFuture {

	public static void main(String[] args) throws InterruptedException {
		
		List<String> pays = Arrays.asList("India","Pakistan","Bangladesh","Sirlanka","Indonesia");
		List<String> cities = Arrays.asList("Toronto","Vancouver","Ottawa","Calgary","Montreal");
		List<Integer> len = conLen(pays);
		System.out.println(len);
		CompletionStage<String> name = ContryComb(pays);
		System.out.println(name.toCompletableFuture().join());
		CompletionStage<String> name2 = ContryComb2(cities);
		System.out.println(name2.toCompletableFuture().join());
		List<Integer> len2 = conLen2(cities);
		System.out.println(len2);
		
		
		
		Hello();
		
		
	}

	public static void Hello()
	{
		System.out.println("I just want to say Hello ...");
	}
	
	public static void delay() { try {
		Thread.sleep(3000L);
		} catch (InterruptedException e) 
	{ throw new RuntimeException(e);
		} 
	}
	
	
	
	public static CompletionStage<String> ContryComb(List<String> lista) 
	{ 
		
		return CompletableFuture.supplyAsync(() -> lista.parallelStream().collect(joining(" * ")));
	}
	
	public static CompletionStage<String> ContryComb2(List<String> lista) 
	{ 
		
		return CompletableFuture.supplyAsync(() -> lista.parallelStream().collect(joining(" * ")));
	}
	
	//This code basically does the same but with the try-catch
	/*public static CompletionStage<String> ContryComb(List<String> lista) throws InterruptedException
	{
		CompletableFuture<String> future = new CompletableFuture<>();

		new Thread(()->{try {
			delay();
		String result = lista.stream().collect(joining("-"));
		future.complete(result);
		}catch(Exception ex)
		{
			future.completeExceptionally(ex);
		}
		}).start();
		return future;
	}*/
	
	/*public static CompletionStage<String> ContryComb(List<String> lista) throws InterruptedException
	{
		CompletableFuture<String> future = new CompletableFuture<>();
		
		
		new Thread(()->{
			delay();
		String result = lista.stream().collect(joining("-"));
		future.complete(result);
		}).start();
		return future;
	}*/
	
	public static List<Integer> conLen(List<String> lista)
	{
		delay();
		return lista.parallelStream().map(x->x.length()).collect(toList());
	}
	
	public static List<Integer> conLen2(List<String> lista)
	{
		@SuppressWarnings("unused")
		List<CompletableFuture<Integer>> lenfuture = lista.stream()
				.map(x-> CompletableFuture.supplyAsync(()->x.length())).collect(Collectors.toList()),executor;
		
		return lenfuture.stream().map(CompletableFuture::join).collect(toList());
	}
	
}
