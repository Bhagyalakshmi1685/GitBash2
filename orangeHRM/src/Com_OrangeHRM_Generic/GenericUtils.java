package Com_OrangeHRM_Generic;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class GenericUtils 
{
	public static void getScreenshot(WebDriver driver,String name)
	{
		SimpleDateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String date = d.format(new Date());
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/"+date+"-"+name+".png");
		try
		{
			Files.copy(src, dest);
		}
		catch (IOException e)
		{
			
		}		
	}
	
	public static void selectTheOptionsBasedOnIndex(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	public static void selectTheOptionsBasedOnValue(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	public static void selectTheOptionsBasedOnText(WebElement element, String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	public static void deselectTheOptionsBasedOnIndex(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.deselectByIndex(index);
	}
	public static void deselectTheOptionsBasedOnValue(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.deselectByValue(value);
	}
	public static void deselectTheOptionsBasedOnText(WebElement element, String text)
	{
		Select sel = new Select(element);
		sel.deselectByVisibleText(text);
	}
	public static void fileDownloadPopup()
	{
		try
		{
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ALT);
			r.keyPress(KeyEvent.VK_S);
			Thread.sleep(1000);
			r.keyRelease(KeyEvent.VK_S);
			r.keyRelease(KeyEvent.VK_ALT);
			Thread.sleep(1000);
			r.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(1000);
			r.keyRelease(KeyEvent.VK_ENTER);
		}
		catch(Exception e)
		{
			
		}
		
	}
}
