package lab4;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReducingOperations {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(2,3,4,5,7,9);
		
		Optional<Integer> suma = numbers.stream()
					.reduce((a,b) -> a+b);
					
		System.out.println("The sum of the arrays is: ");
		System.out.println(suma);
		
		Optional<Integer> producto = numbers.stream()
						.reduce((a,b)->a*b);
		
		System.out.println("The product of all this elements is: ");
		System.out.println(producto);
		
		Optional<Integer> suma2 = numbers.stream().reduce(Integer::sum);
				
	System.out.println("The sum of the arrays using another approach: ");
	System.out.println(suma2);
	
	Optional<Integer> max = numbers.stream().reduce(Integer::max);
	System.out.println("The max value is: ");
	System.out.println(max);
	
	Optional<Integer> min = numbers.stream().reduce(Integer::min);
	System.out.println("The max value is: ");
	System.out.println(min);
	}

}
