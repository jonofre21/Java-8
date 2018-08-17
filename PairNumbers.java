package lab4;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class PairNumbers {

	public static void main(String[] args) {
		
		List<Integer> list1 = Arrays.asList(1,2,3);
		List<Integer> list2 = Arrays.asList(3,4);
		
		List<int[]> pairs = list1.stream()
							.flatMap(i -> list2.stream().filter(j ->(i+j)%3==0).map(j -> new int[]{i,j}))
							.collect(toList());
		
		for (int[] a: pairs) {
			for (int i=0; i < a.length; i++) {
				System.out.print(a[i]+" ");
			}
			System.out.println();
		}
	}

}
