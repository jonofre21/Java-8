package lab11;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.counting;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toSet;

import java.util.HashSet;

import static java.util.stream.Collectors.toCollection;

public class GroupingDish {

	public static void main(String[] args) {
		
		
		//We classify the Dishes by Type by creating a Map that has a classification function  which is the getType enum
		//and through this we can get the values of the HashMap
		Map<Dish.Type, List<Dish>> dishesByType = Dish.menu.stream().collect(groupingBy(Dish::getType));
		System.out.println(dishesByType);
		
		
		
		//In this other case is not possible because we don't have a defined classification function in this case we can create
		//our own classification function which is an enum ...
		Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = Dish.menu.stream()
				.collect( groupingBy(dish -> 
				{ if (dish.getCalories() <= 400) return CaloricLevel.DIET; else if (dish.getCalories() <= 700) return
						CaloricLevel.NORMAL; else return CaloricLevel.FAT; } ));
		System.out.println(dishesByCaloricLevel);
		
		//In this example we are multigrouping results, for example we are using a map inside a map, the outer map has the keys
		//that will rule the rest of the operation, the keys of the second map will have the second criteria of grouping and finally
		//the values of the inner map has the result or the expected data.
		Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesbyTypeandCal = 
				Dish.menu.stream().
				collect(groupingBy(Dish::getType,groupingBy(dish -> 
				{ if (dish.getCalories() <= 400) return CaloricLevel.DIET; else if (dish.getCalories() <= 700) return
						CaloricLevel.NORMAL; else return CaloricLevel.FAT; })));
					System.out.println(dishesbyTypeandCal);
					
		//In this example we count the number of dishes by 	type ...		
		Map<Dish.Type, Long> typesCount = Dish.menu.stream().collect( groupingBy(Dish::getType, counting()));
		System.out.println(typesCount);
		
		//In this example we get the dish with the highest calories per type.
		Map<Dish.Type, Optional<Dish>> mostCaloricByType = Dish.menu.stream() 
		.collect(groupingBy(Dish::getType, maxBy(comparingInt(Dish::getCalories))));
		System.out.println(mostCaloricByType);
		
		//Basically we are getting the dish with the highest calories per type but this time removing the annoying Optional<Dish>
		Map<Dish.Type, Dish> mostCaloricByType2 = Dish.menu.stream()
				.collect(groupingBy(Dish::getType,collectingAndThen(maxBy(comparingInt(Dish::getCalories)),Optional::get)));
		System.out.println(mostCaloricByType2);
		
		//The sum of all calories of all dishes per type ...
		Map<Dish.Type, Integer> totalCaloriesByType = Dish.menu.stream().collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));
			System.out.println(totalCaloriesByType);
		//Collecting all the type of caloric dishes per Type ...
			Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType2 = Dish.menu.stream()
					.collect(groupingBy(Dish::getType, mapping( dish -> 
					{ if (dish.getCalories() <= 400) return CaloricLevel.DIET; 
					else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL; else return CaloricLevel.FAT; },toSet() )));
		System.out.println(caloricLevelsByType2);	
		
		//Collecting all the type of caloric dishes per Type but through a HashSet
		Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType3 = Dish.menu.stream()
				.collect(groupingBy(Dish::getType, mapping(dish -> 
				{ if (dish.getCalories() <= 400) return CaloricLevel.DIET; 
				else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL; else return CaloricLevel.FAT; },
				toCollection(HashSet::new) )));
		System.out.println(caloricLevelsByType3);
		
				
				
	
	}
	
					
		
	
	
//Classification function for the second example ...
		public enum CaloricLevel { DIET, NORMAL, FAT }


	}




