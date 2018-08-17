package lab11;
import static java.util.stream.Collectors.*;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class LabExercises {

	public static void main(String[] args) {
		
		//Concatenating Strings using joining - This is the easier way to do it ...
		String shortMenu = Dish.menu.stream().map(Dish::getName).collect(joining(" - "));
		System.out.println(shortMenu);
		
		//Concatenating Strings using reducing which accumulates values.
		String reduceName = Dish.menu.stream().map(Dish::getName).collect(reducing((a,b)->a+b)).get();
		System.out.println(reduceName);
		
		//Concatenating Strings using reducing which accumulates values with an initial value.
		String reduceName2 = Dish.menu.stream().collect(reducing("",Dish::getName,(a1,a2)->a1+a2));
		System.out.println(reduceName2);
		
		//In this code we are getting all the dishes that are vegetarian and which weight is greater than 500
		Map<Boolean, Map<Boolean, List<Dish>>>isVeggie = Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian,
                partitioningBy(d -> d.getCalories() > 500)));
		System.out.println(isVeggie);
		
		Map<Boolean, Long> NumberOfVeggie = Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian,
                counting()));
		System.out.println(NumberOfVeggie);
		
		// Finding the dish with the longest name collect ...
		Optional<Dish> Maxname = Dish.menu.stream().collect(maxBy(Comparator.comparing(Dish::getName)));
		System.out.println(Maxname);
		// Finding the dish with the longest name reduce
		String Maxname2 = Dish.menu.stream().map(x->x.getName()).reduce("", (a,b) -> a.length() < b.length() ? b:a); 
		System.out.println(Maxname2);
	}

}
