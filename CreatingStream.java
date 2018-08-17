package lab4;

import java.util.Arrays;
import java.util.stream.Stream;

public class CreatingStream {

	public static void main(String[] args) {
		
		int[] numbers= {5,1,2,7,5,8,10,3,9};
		Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action"); 
		stream.map(String::toUpperCase).forEach(System.out::println);

		Stream<String> emptyStream = Stream.empty();
		
		int sum= Arrays.stream(numbers).sum();
		
		System.out.println(sum);
		
		
	}

}
