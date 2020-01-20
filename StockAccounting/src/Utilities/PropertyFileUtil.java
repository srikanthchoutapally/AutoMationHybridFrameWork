package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtil 
{

	public static String getValueForKey(String key) throws Throwable
	{
		Properties configProperties=new Properties();
		FileInputStream fis=new FileInputStream("E:\\Live project\\AutomationTesting\\StockAccounting\\PropertiesFile\\Environment.properties");	
		configProperties.load(fis);
		
		return configProperties.getProperty(key);
	}
}
