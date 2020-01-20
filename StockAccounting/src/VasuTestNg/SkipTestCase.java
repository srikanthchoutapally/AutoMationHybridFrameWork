package VasuTestNg;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class SkipTestCase
{
	@Test
	public void withoutSkip()
	{
		System.out.println("withoutSkip Executed");
	}
	@Test
	public void skipTest()
	{
		throw  new SkipException("Skip test case is not ready");
	}
}
