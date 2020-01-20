package DriverFactory;

import org.openqa.selenium.WebDriver;

import CommonFunLibrary.FunctionLibrary;
import Utilities.ExcelFileUtil;

public class DriverScript
{
WebDriver driver;
	public void startTest() throws Throwable
	{
		//Create Object reference for reusing Excel Methods
		ExcelFileUtil excel=new ExcelFileUtil();
		
		//Working with "MasterTestCases" Sheet
		for (int i = 1; i <=excel.rowCount("MasterTestCases"); i++)
		{
			
			String ModuleStatus="";
			System.out.println(excel.getData("MasterTestCases", i, 2));
			if(excel.getData("MasterTestCases", i, 2).equalsIgnoreCase("Y"))
			{
				//Define Module(Test Cases) Name
				String TCModule=excel.getData("MasterTestCases", i, 1);
				// Working with "TCModule(Test Cases Steps)" Sheet
				int rowcount=excel.rowCount(TCModule);
				for (int j = 1; j<=rowcount; j++) 
				{
					String Description=excel.getData(TCModule, j, 0);
					String Object_Type=excel.getData(TCModule, j, 1);
 					String Locator_Type=excel.getData(TCModule, j, 2);
					String Locator_Value=excel.getData(TCModule, j, 3);
					String Test_Data=excel.getData(TCModule, j, 4);
					try
					{
					if (Object_Type.equalsIgnoreCase("startBrowser"))
					{
						driver=FunctionLibrary.startBrowser(driver);
					}
					if (Object_Type.equalsIgnoreCase("openApplication")) 
					{
						FunctionLibrary.openApplication(driver);
					}
					if (Object_Type.equalsIgnoreCase("typeAction")) 
					{
						FunctionLibrary.typeAction(driver, Locator_Type, Locator_Value, Test_Data);
						
					}
					if (Object_Type.equalsIgnoreCase("clickAction"))
					{
						FunctionLibrary.clickAction(driver, Locator_Type, Locator_Value);
						
					}
					if (Object_Type.equalsIgnoreCase("waitForElement")) 
					{
						FunctionLibrary.waitForElement(driver, Locator_Type, Locator_Value, Test_Data);
					}
				    if (Object_Type.equalsIgnoreCase("closeBrowser")) 
					{
						FunctionLibrary.closeBrowser(driver);
					}
					if (Object_Type.equalsIgnoreCase("pageDown"))
					{
						FunctionLibrary.pageDown(driver);
					}
					if (Object_Type.equalsIgnoreCase("captureData"))
					{
						FunctionLibrary.captureData(driver, Locator_Type, Locator_Value);
					}
					if (Object_Type.equalsIgnoreCase("tableValidation"))
					{
						FunctionLibrary.tableValidation(driver, Test_Data);
					}
					excel.setData(TCModule, j, 5, "PASS");
					ModuleStatus="true";
					}catch(Exception e)
					{
					excel.setData(TCModule, j, 5, "FAIL");
					ModuleStatus="false";
					break;
					}
					
				}
				if(ModuleStatus.equalsIgnoreCase("true"))
				{
					excel.setData("MasterTestCases",i,3,"PASS");
				}else
					if(ModuleStatus.equalsIgnoreCase("false"))
					{
						excel.setData("MasterTestCases",i,3,"FAIL");
					}
			}
			else
			{
				excel.setData("MasterTestCases",i,3,"Not Executed");
			}
		}
		
		
	}
	public static void main(String[] args) throws Throwable {
		ExcelFileUtil excel=new ExcelFileUtil();
		System.out.println(excel.getData("MasterTestCases", 1, 3));
		
	}
}
