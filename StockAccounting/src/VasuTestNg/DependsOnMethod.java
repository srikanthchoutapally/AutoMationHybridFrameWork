package VasuTestNg;

import org.junit.Assert;
import org.testng.annotations.Test;

public class DependsOnMethod 
{

	@Test()
	public void urlLaunch()
	{
		System.out.println("urlLaunch Executed");
		Assert.fail();
	}
	@Test(dependsOnMethods="urlLaunch",alwaysRun=true)
	public void enterCredentials()
	{
		System.out.println("enterCredentials Executed");
	}
	@Test(dependsOnMethods="enterCredentials")
	public void login()
	{
		System.out.println("login Executed");
	}
	
}
