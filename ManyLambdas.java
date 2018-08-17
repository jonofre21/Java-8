package lab3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;


public class ManyLambdas {

	public static void main(String[] args) {
	
		List<Integer> numbers = Arrays.asList(5,3,5,6,3,2,6,7,9,11,1,10,2);
		System.out.println("Before Applying Lambdas");
		System.out.println(numbers);
		System.out.println("After Applying Lambdas");
		List<Integer> even = myCustomFilter(numbers,(Integer i)->i%2==0);
		System.out.println(even);
		
		numbers.sort(Comparator.naturalOrder());
		
		System.out.println("Numbers sorted in Natural order ...");
		System.out.println(numbers);

		numbers.sort(Comparator.reverseOrder());
		System.out.println("Numbers sorted in Reverse order ...");
		System.out.println(numbers);
		
		Runnable r = ()-> System.out.println("Hello Quebec City ...");
		r.run();

	}

	public static <T> List<T> myCustomFilter(List<T> numbers, Predicate<T> p)
	{
		List<T> result = new ArrayList<>();
		for(T a:numbers)
		{
			if (p.test(a)) {
			result.add(a);
			}
		}
		return result;
	}
	
		
}
