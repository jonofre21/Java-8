package lab3;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class CreatingApples {

	public static void main(String[] args) {
		
		BiFunction<Integer,String, Apple2> c3 = Apple2::new;
		
		Apple2 c4 = c3.apply(110, "green");
		
		List<Apple2> list1 = new ArrayList<>();
		List<Apple> list2 = new ArrayList<>();
		list1.add(c4);
		System.out.println("List of Apple2");
		for (Apple2 apple2 : list1) {
			
			System.out.println(apple2.getColor()+" "+apple2.getWeight());
		}
		
		TriFunction<Integer,String, Double, Apple> b1 = Apple::new;
		Apple c1 = b1.appl(110, "green",11.10);
		list2.add(c1);
		System.out.println("List of Apple");
		for (Apple apple : list2) {
			
			System.out.println(apple.getColor()+" "+apple.getWeight()+" "+apple.getPrice());
		}
		
	}
	
	public interface TriFunction<T, U, V, R>
	{ 
		R appl(T t, U u, V v);
	}

}
