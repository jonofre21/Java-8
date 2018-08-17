package apps;
import java.util.*;
import java.util.function.*;


public  class PracticeTask2 {
	

	public static List<Apple> inventory  = Arrays.asList(new Apple(80,"green",5.55),
            new Apple(155, "green",10.77),
            new Apple(120, "red",8.88),
            new Apple(100, "yellow",6.25),
            new Apple(110, "brown",2.30)
			);;
	

	
	  
		 
		 
		 
	

	public static void main(String ... args){
		 
	jesus();
	        
	 }
	 
	/**
	 * This is the old fashion way of filtering, in this way we are really limited because
	 * it is just filtering by green apples and if we want to filter by red apples or by price
	 * or by weight, etc, we have to create as many methods as need it.
	 * @param inventory
	 * @return
	 */
	
	public static void jesus() {
		
		//Old fashion way of filtering things
		
		System.out.println(inventory);
	       System.out.println(greenApples(inventory));
	        //Old fashion way of filtering things
	      // System.out.println(greenApples(inventory));
	       
	        //In this way we are passing a Predicate to filter the apples according to the lambda
	       // expression.
	        List<Apple> myfilter=myCustomFilter(inventory, (Apple a) -> a.getPrice()>8.7);
	        System.out.println(myfilter);
	        
	        //We can also filter by method references in which we pass the Class and the method.
	        List<Apple> myfilterbyred = myCustomFilter(inventory,PracticeTask2::isRedApple);
	        System.out.println(myfilterbyred);
	}
	
	public static List<Apple> greenApples(List<Apple> inventory)
	{
		List<Apple> result = new ArrayList<>();
		for(Apple a:inventory)
		{
			if(a.getColor().equalsIgnoreCase("green"))
			{
				result.add(a);
			}
		}
		return result;
	}
	 
	public static boolean isRedApple(Apple apple)
	{
		return apple.getColor().equalsIgnoreCase("red");
	}
	
	public static List<Apple> myCustomFilter(List<Apple> inventory, Predicate<Apple> p)
	{
		List<Apple> result = new ArrayList<>();
		for(Apple a:inventory)
		{
			if (p.test(a)) {
			result.add(a);
			}
		}
		return result;
	}
	
	/**
	 * We are defining a Predicate which is a Functional interface that has a method
	 * that receives a value of type T and returns a boolean, Predicate is basically for
	 * filtering objects, it is not necessary to declare the interface because Java 8 includes as
	 * a library on java.util.function.*;
	 *
	 */
	

}
