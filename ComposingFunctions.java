package lab3;
import java.util.function.*;

public class ComposingFunctions {

	public static void main(String[] args) {
		
		Function<Integer,Integer> f = x-> x+1;
		Function<Integer,Integer> g = x-> x*2;
		Function<Integer,Integer> h = f.andThen(g);
		int r = h.apply(1);
		System.out.println("Printing r from andThen function "+r);
		Function<Integer,Integer> i = x-> x+1;
		Function<Integer,Integer> j = x-> x*2;
		Function<Integer,Integer> k = i.compose(j);
		int r2 = k.apply(1);
		System.out.println("Printing r2 from compose function "+r2);

	}

}
