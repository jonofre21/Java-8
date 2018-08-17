package lab11;
import static java.util.stream.Collectors.reducing;

import java.util.Optional;


public class Reduction {

	public static void main(String[] args) {
		
		//Summing numbers using reducing which takes two parameters, one is the stating point which is 0 and a BiFuncion.
		int totalCalories = Dish.menu.stream().collect(reducing( 0, Dish::getCalories, (i, j) -> i + j));
		System.out.println(totalCalories);
		
		//Finding the highest value through the method reducing ...
		Optional<Dish> mostCalorieDish = Dish.menu.stream().collect(reducing( (d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
		System.out.println(mostCalorieDish);
		
		//Another summing operation using reducing ...
		int totalcalories = Dish.menu.stream().collect(reducing(0,Dish::getCalories,Integer::sum));
		System.out.println(totalcalories);
		
		//Another summing operation using reduce ...
		int totalCalories3 = Dish.menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
		System.out.println(totalCalories3);
		
		//Getting a String of names with reducing method
		String shortMenu = Dish.menu.stream().map(Dish::getName) .collect( reducing( (s1, s2) -> s1 + s2 ) ).get();
		System.out.println(shortMenu);
		
		//Getting a String of names with reducing method another approach
		String shortMenu2 = Dish.menu.stream() .collect( reducing( "", Dish::getName, (s1, s2) -> s1 + s2 ) );
		System.out.println(shortMenu2);
	}

}
