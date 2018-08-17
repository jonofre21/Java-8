package lab11;

import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.summarizingInt;;

public class Summarization {

	public static void main(String[] args) {
		//This method sums all the calories in the dish
		int totalCalories = Dish.menu.stream().collect(summingInt(Dish::getCalories));
		System.out.println("Summing all calories ...");
		System.out.println(totalCalories);
		
		//This method calculates the average of all the calories of all dishes ...
		double averageCalories = Dish.menu.stream().collect(averagingInt(Dish::getCalories));
		System.out.println("The calories average is :"+averageCalories);
		
		//Printing the menu statistics ...
		System.out.println("Next you will find the menu statistics ...");
		IntSummaryStatistics menuStatistics = Dish.menu.stream().collect(summarizingInt(Dish::getCalories));
		System.out.println(menuStatistics);
		
		
	}

}
