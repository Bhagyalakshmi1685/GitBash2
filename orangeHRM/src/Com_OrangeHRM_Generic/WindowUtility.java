package Com_OrangeHRM_Generic;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WindowUtility
{
	public void windowPopup(String file_path)
	{
		try
		{
			Runtime.getRuntime().exec(file_path);
		}
		catch(Exception e)
		{
			
		}
	}
	
	public static void switchWindow(WebDriver driver, String etitle)
	{
		Set<String> allwin = driver.getWindowHandles();
		Iterator<String> itr = allwin.iterator();
		while(itr.hasNext())
		{
			String win = itr.next();
			driver.switchTo().window(win);
			if(driver.getTitle().equals(etitle))
			{
				break;
			}
		}
	}

}
