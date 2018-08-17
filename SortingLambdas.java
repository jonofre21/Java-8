package lab3;

import java.util.Arrays;
import java.util.List;
import static java.util.Comparator.comparing;

public class SortingLambdas {

	

	
	public static void main(String[] args) {
		
		List<Apple> inventory  = Arrays.asList(new Apple(80,"green",5.55),
	            new Apple(155, "green",10.77),
	            new Apple(120, "red",8.88),
	            new Apple(100, "green",7.50),
	            new Apple(100, "yellow",6.25),
	            new Apple(110, "brown",2.30)
				);;
				System.out.println("Before Sorting with lambdas...");
				System.out.println(inventory);
				
				inventory.sort((Apple a1, Apple a2)->a1.getWeight().compareTo(a2.getWeight()));
				System.out.println("After Sorting with lambdas...");
				System.out.println(inventory);
				System.out.println("Sorting elements  by price ...");
				inventory.sort(comparing(Apple::getPrice));
				System.out.println(inventory);
				
				System.out.println("Composing double sorting ...");
				inventory.sort(comparing(Apple::getPrice).reversed().thenComparing(Apple::getWeight));
				System.out.println(inventory);
		
	}

}
