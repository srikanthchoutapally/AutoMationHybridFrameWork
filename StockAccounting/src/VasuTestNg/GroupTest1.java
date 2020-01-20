package VasuTestNg;

import org.testng.annotations.Test;

public class GroupTest1 
{
	@Test(groups="REG")
	public void reg()
	{
		System.out.println("reg Executed");
	}
	@Test(groups="SMOKE")
	public void smoke()
	{
		System.out.println("smoke Executed");
	}
}
