package lab4;

import java.util.stream.IntStream;


public class Range {

	public static void main(String[] args) {
		
		//the method range is non inclusive
		IntStream evenNumbers = IntStream.range(1,100)
				.filter(n->n%2==0);
		System.out.println("Printing using range");
		System.out.println(evenNumbers.count());
		
		//the method rangeClosed is inclusive
				IntStream evenNumbers2 = IntStream.rangeClosed(1,100)
						.filter(n->n%2==0);
				System.out.println("Printing using rangeClosed");
				System.out.println(evenNumbers2.count());


	}

}
