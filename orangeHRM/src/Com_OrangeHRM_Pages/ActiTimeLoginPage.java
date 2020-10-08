package Com_OrangeHRM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com_OrangeHRM_Generic.BasePage;

public class ActiTimeLoginPage extends BasePage
{
	@FindBy(id = "username")
	private WebElement untb;
	@FindBy (name = "pwd")
	private WebElement pwtb;
	@FindBy (xpath = "//div[text()='Login ']")
	private WebElement lgbt;
	@FindBy (xpath = "//span[text()='Username or Password is invalid. Please try again.']")
	private WebElement error;
	@FindBy ( xpath = "//nobr[contains(text(),'actiTIME')]")
	private WebElement version;
	public ActiTimeLoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	public void enterUsername(String un)
	{
		untb.sendKeys(un);
	}
	public void enterPassword(String pw)
	{
		pwtb.sendKeys(pw);
	}
	public void clickOnLoginButton()
	{
		lgbt.click();
	}
	public String verifyErrorMsg()
	{
		verifyElement(error);
		String aerror  = error.getText();
		return aerror;
	}
	public String verifyVersion()
	{
		verifyElement(version);
		String aversion = version.getText();
		return aversion;
	}
	

}
