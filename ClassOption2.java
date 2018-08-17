package lab12;

import java.util.Optional;
import java.util.Properties;

import java.util.Optional;



public class ClassOption2 {

	public static void main(String[] args) {
		
		Properties props = new Properties(); props.setProperty("a", "5"); props.setProperty("b", "true"); props.setProperty("c", "-3");
		
		Optional<Integer> stoi = stringToInt("88");
		System.out.println(stoi);
		
	}

	public static Optional<Integer> stringToInt(String text)
	{
		try {
			return Optional.of(Integer.parseInt(text));
			
		}catch(NumberFormatException e)
		{
			return Optional.empty();
		}
	}
	
	
}
