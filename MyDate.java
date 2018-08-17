package lab3;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.text.DateFormatter;

/**
 * 
 * @author Jesus
 * 
 * This exercise was part of the Lab 3 task 4 in which we were asked for implement a
 * safe thread for formatting dates.
 * Java 8 has a new method called withInitial in which we use a lambda expression for manipulating
 * the supplier functional interface that we use as a parameter.
 */

public class MyDate {

	public static void main(String[] args) {
		
		System.out.println("Before Formatting ...");
		Date date = new Date();
		System.out.println(date);
		
		
		final ThreadLocal<SimpleDateFormat> formatter = 
				ThreadLocal.withInitial(() -> new SimpleDateFormat("dd-MMM-yyyy"));
		
		System.out.println("After Formatting ...");
		
		System.out.println(formatter.get().format(date));
		
		//A fucking thread for printing Hello World !!! Ohhh Fuck ...
		Thread t = new Thread(() -> System.out.println("Hello world"));
		t.start();
		
		
	}

}
