package lab3;

import java.util.function.Function;

public class Letter {

	public static void main(String[] args) {
		
		Function<String, String> addHeader = Letter::addHeader; 
		Function<String, String> transformationPipeline = addHeader.andThen(Letter::checkSpelling) 
				.andThen(Letter::addFooter);
		String carta = transformationPipeline.apply("Hey, How have you been? I am here with labda");
		System.out.println(carta);
	}
	
	public static String addHeader(String text)
	{ return "From Jesus to X : " + text;
	}
	
	public static String addFooter(String text)
	{ return text + " Kind regards";
	}
	
	public static String checkSpelling(String text)
	{ return text.replaceAll("labda", "lambda");
	}

}
