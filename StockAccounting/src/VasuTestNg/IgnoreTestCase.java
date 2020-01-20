package VasuTestNg;

import org.testng.annotations.Test;

public class IgnoreTestCase 
{
	@Test(invocationCount=5)
	public void method1()
	{
		System.out.println("Method1 Executed");
	}
	@Test(enabled=false)
	public void method2()
	{
		System.out.println("Method2 Executed");
	}
}
