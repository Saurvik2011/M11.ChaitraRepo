package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {
	
	@Test
	public void sample()
	{
		String a = "Hi";
		
		System.out.println("step 1");
		System.out.println("step 2");
		System.out.println("step 3");
		
		//Assert.assertEquals("a", "A");
		
		Assert.assertTrue(a.contains("I"));
		
		System.out.println("step 4");
		System.out.println("step 5");
		
		System.out.println("step 5");
		
	}

	@Test
	public void sample1()
	{
		SoftAssert sa = new SoftAssert();
		
		String a = "Hi";
		
		System.out.println("step 1");
		
		sa.assertTrue(false);//fail
		
		System.out.println("step 2");
		System.out.println("step 3");
		
		sa.assertEquals(0, 1);//fail
		
		
		System.out.println("step 4");
		System.out.println("step 5");
		
		sa.assertAll();//log the assert failures
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
