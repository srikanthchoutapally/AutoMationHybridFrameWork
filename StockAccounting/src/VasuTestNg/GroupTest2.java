package VasuTestNg;

import org.testng.annotations.Test;

public class GroupTest2 
{
	@Test(groups="FUN")
	public void fun()
	{
		System.out.println("Fun Executed");
	}
	@Test(groups="SMOKE")
	public void smoke()
	{
		System.out.println("smoke Executed");
	}
}
