package apps;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;


public class StreamVsCollection {

    public static void main(String...args){
        List<String> names = Arrays.asList("Java8", "Lambdas", "In", "Action");
        Stream<String> s = names.stream();
        s.forEach(System.out::println);
        // uncommenting this line will result in an IllegalStateException
        // because streams can be consumed only once
        //s.forEach(System.out::println);
        List<Integer> lens = names.stream()
        					.map(z->z.length())
        					.collect(toList());
        System.out.println(lens);
        
        System.out.println("First attempt ...");
        List<String[]> words = names.stream()
        					.map(w ->w.split(" "))
        					.collect(toList());
        System.out.println(words);
        
        System.out.println("Second attempt ...");
        List<String> words2 = names.stream()
        					.map(w->w.split(""))
        					.flatMap(Arrays::stream)
        					.distinct()
        					.collect(toList());
        System.out.println(words2);
        
    }
}