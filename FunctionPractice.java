package lab3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionPractice {

	public static void main(String[] args) {
		
		List<String> pays = Arrays.asList("Mexico","Honduras","Canada","India");
		System.out.println(pays);
		System.out.println("Printing the lenght of every country name ...");
		
		List<Integer> lengy = lenpay(pays,(String s)-> s.length());
		
		System.out.println(lengy);
		
	}
	
	public static  <R, T> List<R> lenpay(List<T> pays, Function<T,R> f)
	{
		List<R> result = new ArrayList<>();
		for(T n:pays)
		{
			
			result.add(f.apply(n));
		}
		return  result;
	}
	

}
