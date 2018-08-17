package lab3;

import java.util.stream.Stream;

public class Fibonacci {

	public static void main(String[] args) {
		
		Stream.iterate(0,n->n+2)
		.limit(100)
		.forEach(System.out::println);
		
		Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0]+t[1]})
		.limit(20) .forEach(t -> System.out.println("(" + t[0] + "," + t[1] +")"));
		
		//Using the normal Fibonacci ...
		System.out.println("Another way of Printing the fibonacci ...");
		
		Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1],t[0] + t[1]})
		.limit(20) .map(t -> t[0]) .forEach(System.out::print);
		System.out.println();
		System.out.println("Using the method Generate for printing Random numbers ...");
		Stream.generate(Math::random) .limit(5) .forEach(System.out::println);
	}

}
