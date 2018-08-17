package lab11;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.partitioningBy;

public class PrimeNumber {

	public static void main(String[] args) {
		
		
		Map<Boolean, List<Integer>> par = partitionPrimes(100);
		
		System.out.println(par);
		
	}
	
	public static boolean isPrime(int candidate) 
	
	{ int candidateRoot = (int) Math.sqrt((double) candidate);
	return IntStream.rangeClosed(2, candidateRoot) .noneMatch(i -> candidate % i == 0);
	}
	
	public static Map<Boolean, List<Integer>> partitionPrimes(int n) 
	{ 
		return IntStream.rangeClosed(2, n).boxed() .collect( partitioningBy(candidate -> isPrime(candidate)));
	
	}

}
