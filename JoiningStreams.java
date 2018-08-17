package lab11;
import static java.util.stream.Collectors.joining;
import java.util.stream.Collectors;

public class JoiningStreams {

	public static void main(String[] args) {
		
		String shortMenu = Dish.menu.stream().map(Dish::getName).collect(joining(" - "));
		
		System.out.println(shortMenu);
		
		//I dont know why this one is not working maybe because I need to pass an String and I am passing the whole Dish Asshole ...
		//String shortMenu2 = Dish.menu.stream().collect(joining(","));

	}

}
