package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import classes.Calculator;

public class TestCalculator {

	
	@Test
	public void testConsecs1Run(){
		int[] cardValues= {11,11,3,4,7};
		Calculator run =  new Calculator();
		ArrayList<Integer> results = run.consecValues(cardValues, 1); 
		int output = results.size();
		int expected = 2;
		assertEquals(expected, output);
	}
	
	/**
	 * test for multiple consecutives (select the one with higher index, therefore high value cards)
	 * 
	 */
	@Test
	public void testConsecs2Runs(){
		int[] cardValues= {10,11,3,4,7};
		Calculator run =  new Calculator();
		ArrayList<Integer> results = run.consecValues(cardValues, 1); 
		int output = results.get(0);
		int expected = 10;
		assertEquals(expected, output);
	}
	
	@Test
	public void testNearConsecs1Run() {
		int[] cardValues= {10,10,3,4,7};
		Calculator run =  new Calculator();
		ArrayList<Integer> results = run.consecValues(cardValues,2); 
		int output = results.size();
		int expected = 2;
		assertEquals(expected, output);
	}
	
	/**test for multiple runs, should overwrite the list with a list with higher index
	 * currently fails in unexpected way - its not ordered
	 * */
	@Test
	public void testNearConsecs2Runs() {
		int[] cardValues= {10,11,3,4,7};
		Calculator run =  new Calculator();
		ArrayList<Integer> results = run.consecValues(cardValues, 2); 
		int output = results.get(0);
		int expected = 10;
		assertEquals(expected, output);
	}
	
	@Test
	public void testCreateList(){
		int[] cardValues= {9,10,3,4,7};
		int size = 2;
		int index = 1;
		Calculator run =  new Calculator();
		ArrayList<Integer> results = run.createList(size, index, cardValues); 
		assertEquals(2, results.size());
	}

	@Test
	public void testSameValues(){
		int[] cardValues= {5,9,5,4,4};
		Calculator run =  new Calculator();
		ArrayList<Integer> results = run.sameValues(cardValues); 
		assertEquals(4, results.size());
	}
	
	@Test
	public void testStatus(){
	
	}
}
