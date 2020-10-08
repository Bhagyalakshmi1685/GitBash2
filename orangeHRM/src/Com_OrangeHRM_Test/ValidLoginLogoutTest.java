package Com_OrangeHRM_Test;

import org.testng.annotations.Test;

import Com_OrangeHRM_Generic.BaseTest;
import Com_OrangeHRM_Generic.ExcelData;
import Com_OrangeHRM_Pages.ActiTIMEEnterTimeTrackPage;
import Com_OrangeHRM_Pages.ActiTimeLoginPage;

public class ValidLoginLogoutTest extends BaseTest
{
	@Test(priority = 1)
	public void validLoginLogout()
	{
		String un = ExcelData.getData(file_path, "TC01", 1, 0);
		String pw = ExcelData.getData(file_path, "TC01", 1, 1);
		String lgtitle = ExcelData.getData(file_path, "TC01", 1, 2);
		String hptitle = ExcelData.getData(file_path, "TC01", 1, 3);
		ActiTimeLoginPage lp = new ActiTimeLoginPage(driver);
		ActiTIMEEnterTimeTrackPage hp = new ActiTIMEEnterTimeTrackPage(driver);
		lp.verifyTitle(lgtitle);
		lp.enterUsername(un);
		lp.enterPassword(pw);
		lp.clickOnLoginButton();
		hp.verifyTitle(hptitle);
		hp.clickOnLogoutButton();
		lp.verifyTitle(lgtitle);
	}

}
