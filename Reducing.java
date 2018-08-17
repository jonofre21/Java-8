package lab11;
import static java.util.stream.Collectors.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import lab11.Dish;
import java.util.stream.Collectors;

public class Reducing {

	public static void main(String[] args) {

		long hey = howmany(Dish.menu);
		System.out.println(hey);
		//In this example we first are creating a Comparator comparing that will be pass it to the maxBy.
		Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
		Optional<Dish> mostCalorieDish = Dish.menu.stream() .collect(maxBy(dishCaloriesComparator));
		System.out.println(mostCalorieDish);

	}

	static long howmany(List<Dish> mene)
	{
		return mene.stream().collect(Collectors.counting());
	}
}
