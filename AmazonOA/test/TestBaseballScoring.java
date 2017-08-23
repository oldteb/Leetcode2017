package oldteb.leetcode2017.amazonOA;

import static org.junit.Assert.*;

import org.junit.*;

public class TestBaseballScoring {
	
	BaseballScoring instance = new BaseballScoring();
	
	@Test
	public void testSample1(){
		String records = "12-5+XZ10";
		int score = instance.getScore(records);
		
		assertTrue(score == 24);
	}
	
	@Test
	public void testSample2(){
		String records = "ZZ-15-15+";
		int score = instance.getScore(records);
		
		assertTrue(score == -60);
	}
	
	@Test
	public void testSample3(){
		String records = "17ZX5+ZX+010";
		int score = instance.getScore(records);
		
		assertTrue(score == 40);
	}
	
	
}
