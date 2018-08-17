package apps;
import static java.util.stream.Collectors.toList;

import java.util.List;

public class MexicanDish {

	public static void main(String[] args) {
		
		List<String> lowCalories = Dish.menu.stream()
								.filter(a->a.getCalories()<300)
								.map(Dish::getName)
								.collect(toList());
		System.out.println(lowCalories);
		
		List<Integer> calories = Dish.menu.stream()
								.filter(x->x.isVegetarian())
								.map(Dish::getCalories)
								.collect(toList());
		System.out.println(calories);
		
	}
	
	

}
