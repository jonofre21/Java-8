package lab11;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class WordCount {

	public static void main(String[] args) {
		
		Stream<String> names = Stream.of("Pasta", "Fish", "Pasta", "Meat", "Pasta", "Meat");
		//List<String> names = Arrays.asList("Pasta", "Fish", "Pasta", "Meat", "Pasta", "Meat");
		//In this exercise, try implementing a countWords method using a stream collector. That is, given an input stream like
		Map<String,Long> countbyName = names.collect(groupingBy(Function.identity(),counting()));
		System.out.println(countbyName);
	}

}
