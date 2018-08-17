package lab4;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Pythagorean {

	public static void main(String[] args) {
		
		int[] tuples = {3,4,5};
		
		/* This is the first attempt to resolve the problem ...*/
		
		Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed() 
				.flatMap(a-> IntStream.rangeClosed(a, 100) 
						.filter(b -> Math.sqrt(a*a + b*b) % 1 == 0) .mapToObj(b -> new int[]{a, b, (int)Math.sqrt(a * a + b * b)})
						);
		
		pythagoreanTriples.limit(5) .forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
		
		/* This is the second attempt with our code improved ...*/
		Stream<double[]> pythagoreanTriples2 = IntStream.rangeClosed(1, 100).boxed() 
				.flatMap(a-> IntStream.rangeClosed(a, 100) 
						.mapToObj(b -> new double[]{a, b, (int)Math.sqrt(a * a + b * b)})
						.filter(t->t[2]%1==0));
		System.out.println("Printing tuples with an improved stream ...");
		pythagoreanTriples2.limit(5) .forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));		

	}

	

}
