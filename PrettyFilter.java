package lab3;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;




public class PrettyFilter {
	
	static List<Apple> inventory  = Arrays.asList(new Apple(80,"green",5.55),
            new Apple(155, "green",10.77),
            new Apple(120, "red",8.88),
            new Apple(100, "yellow",6.25),
            new Apple(110, "brown",2.30)
			);;
	

	public static void main(String[] args) {
		 
				
				//Here we are calling the method prettyApple but we are passing it as parameters
				//the inventory and an anonymous class that extends of our Format interface
				prettyApple(inventory,new PrintApple());
				
				//Here we are doing almost the same but instead of passing it an anonymous class
				// we are passing a lambda expression.
				prettyApple(inventory,(Apple a)->"An apple of: "+a.getWeight()+" grams");

	}
	
	public static void prettyApple(List<Apple> inventory, AppleFormat f)
	{
		for(Apple apple:inventory)
		{
			String output=f.accept(apple);
			System.out.println(output);
		}
	}
	
	@FunctionalInterface
	public interface AppleFormat
	{
		String accept(Apple apple);
	}
	
	static class PrintApple implements AppleFormat{
		public String accept(Apple apple)
		{
			if(apple.getWeight()>=120)
			{
				return "This is a heavy apple of "+apple.getWeight().toString();
			}
			else
			{
				return "This is a light apple of "+apple.getWeight().toString();
			}
			
		}
	}

	

}
