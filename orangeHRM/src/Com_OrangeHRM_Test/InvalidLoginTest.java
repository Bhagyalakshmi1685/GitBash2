package Com_OrangeHRM_Test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Com_OrangeHRM_Generic.BaseTest;
import Com_OrangeHRM_Generic.ExcelData;
import Com_OrangeHRM_Pages.ActiTimeLoginPage;

public class InvalidLoginTest extends BaseTest 
{
	@Test(priority = 2)
	public void invalidLogin() throws InterruptedException
	{
		String etitle = ExcelData.getData(file_path, "TC01", 1, 2);
		String eerror = ExcelData.getData(file_path, "Tc02", 1, 2);
		ActiTimeLoginPage lp = new ActiTimeLoginPage(driver);
		lp.verifyTitle(etitle);
		int rc = ExcelData.getRowCount(file_path, "Tc02");
		for(int i=1; i<=rc; i++)
		{
			String un = ExcelData.getData(file_path, "TC02", i, 0);
			String pw = ExcelData.getData(file_path, "TC02", i, 1);
			Reporter.log("username = " +un, true);
			lp.enterUsername(un);
			Reporter.log("password = " +pw, true);
			lp.enterPassword(pw);
			lp.clickOnLoginButton();
			String aerror = lp.verifyErrorMsg();
			
			Assert.assertEquals(aerror, eerror);
			Thread.sleep(2000);
			Reporter.log("====================================================");
		}
	}

}
