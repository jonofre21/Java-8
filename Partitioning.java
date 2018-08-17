package lab11;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import lab11.GroupingDish.CaloricLevel;

import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.groupingBy;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.collectingAndThen;

public class Partitioning {

	public static void main(String[] args) {
		//With Partitioning we are basically getting both paths of the returned boolean either true or false
		Map<Boolean,List<Dish>> PartitionedMenu = Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian));
		System.out.println(PartitionedMenu);
		
		//However, in the old fashion way this is not possible because you are basically getting just one path of the boolean.
		List<Dish> vegetarianDishes = Dish.menu.stream().filter(Dish::isVegetarian).collect(toList());
		System.out.println(vegetarianDishes);
		
		Map<Boolean,Map<Dish.Type, List<Dish>>> veggybyType = Dish.menu.stream()
				.collect(partitioningBy(Dish::isVegetarian,groupingBy(Dish::getType)));
				System.out.println(veggybyType);
		
		Map<Boolean, Dish> mostCaloricPartitionedByVegetarian = Dish.menu.stream()
				.collect( partitioningBy(Dish::isVegetarian, collectingAndThen(
						maxBy(comparingInt(Dish::getCalories)), Optional::get)));
		System.out.println(mostCaloricPartitionedByVegetarian);
	}

}
