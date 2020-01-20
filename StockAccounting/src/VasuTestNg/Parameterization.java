package VasuTestNg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Parameterization
{
@Test(dataProvider="getData")
public void login(String username,String password)
{
	System.out.println("UserName is : "+username);
	System.out.println("password is : "+password);
	
}

@DataProvider
public Object[][] getData()
{
	Object[][] data=new Object[2][2];
	
	data[0][0]="VasuDeva1";
	data[0][1]="Selenium1";
	data[1][0]="VasuDeva2";
	data[1][1]="Selenium2";
	return data;
}

}
