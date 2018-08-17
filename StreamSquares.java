package lab4;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class StreamSquares {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		
		Optional<Integer> squares = numbers.stream()
								.map(x-> x*x)
								.filter(x-> x%2==0)
								.findFirst();
								
		System.out.println(squares);
		
		
		int squares2 = numbers.stream()
				.filter(x->x<10)
				.findAny().orElse(-10);

	}

}
