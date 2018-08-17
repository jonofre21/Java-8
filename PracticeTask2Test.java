package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import apps.Apple;
import apps.PracticeTask2;

class PracticeTask2Test {
	
	 
	PracticeTask2 task2 = new PracticeTask2();
	Apple app = new Apple(0, "red", 0);
	
	
	@Test
	public void testGreenApples() {
		
		System.out.println("Testing Empty Green apples ...");
		assertFalse(task2.greenApples(task2.inventory).isEmpty());
	}
	
	@Test
	public void testRedApple()
	{
		System.out.println("Testing Red Apples");
		assertTrue(task2.isRedApple(app));
	}
	
	@Test
	public void testCustomFilter()
	{
		
		PracticeTask2 p = new PracticeTask2();
		System.out.println("Testing Filtered method by color");
		List<Apple> brown = p.myCustomFilter(task2.inventory,(Apple a)->a.getColor().equalsIgnoreCase("brown"));
		assertEquals(1,brown.size());
	}
	
	@Test
	public void testCustomFilterWeigth()
	{
		
		PracticeTask2 p = new PracticeTask2();
		System.out.println("Testing Filtered method by weigth");
		List<Apple> wei = p.myCustomFilter(task2.inventory,(Apple a)->a.getWeight()>150);
		assertEquals(1,wei.size());
	}
	
	@Test
	public void testCustomFilterPrice()
	{
		
		PracticeTask2 p = new PracticeTask2();
		System.out.println("Testing Filtered method by Price");
		List<Apple> prix = p.myCustomFilter(task2.inventory,(Apple a)->a.getPrice()>10.2);
		assertEquals(1,prix.size());
	}
	
	@Test
	public void testToString()
	{
		Apple a = new Apple(0, "green", 0);
		System.out.println("Testing the ToString ...");
		assertTrue(a.toString().length()>1);
	}

}
