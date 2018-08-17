package lab4;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class MyStream {

	public static void main(String[] args) {

		
		List<Dish> firstTwoMeatDishes = Dish.menu.stream()
										.filter(m-> m.getType().equals(Dish.Type.MEAT))				
										.collect(toList());
		System.out.println(firstTwoMeatDishes);
		
		List<String> names = Dish.menu.stream()
							.filter(d-> 
							{System.out.println("Filtering ... "+d.getName());
							return d.getCalories()>300;
							})
							.map(d->
							{
								System.out.println("Mapping ... "+d.getName());
								return d.getName();
							})
							.limit(3)
							.collect(toList());
		System.out.println(names);
		
		System.out.println("---  Other Functions ---");
		
		if(Dish.menu.stream().anyMatch(Dish::isVegetarian))
		{
			System.out.println("How can you survive eating just vegetables ...");
		}
		if(Dish.menu.stream().allMatch(x-> x.getType()==Dish.Type.MEAT))
		{
			System.out.println("This menu looks interesting ...");
		}
		
		Optional<Dish> dish = Dish.menu.stream()
							.filter(Dish::isVegetarian)
							.findAny(); //this is married to Optional ...
							//.ifPresent(d -> System.out.println(d.getName()));
		System.out.println(dish);
		System.out.println("What is Optional and why is necessary to use it ...");
		
		Optional<Integer> dish2 = Dish.menu.stream()
				.map(d->1)
				.reduce(Integer::sum);
		System.out.println("The number of dishes in the menu is: ");
		System.out.println(dish2);
		
		Optional<Integer> dish3 = Dish.menu.parallelStream()
				.map(d->1)
				.reduce(Integer::sum);
		System.out.println("The number of dishes in the menu using ParallelStream is: ");
		System.out.println(dish3);
	}
	
	
	

}
