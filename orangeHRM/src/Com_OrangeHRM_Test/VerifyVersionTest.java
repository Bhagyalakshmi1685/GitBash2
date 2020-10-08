package Com_OrangeHRM_Test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Com_OrangeHRM_Generic.BaseTest;
import Com_OrangeHRM_Generic.ExcelData;
import Com_OrangeHRM_Pages.ActiTimeLoginPage;

public class VerifyVersionTest extends BaseTest
{
	@Test(priority = 3)
	public void verifyVersion()
	{
		String etitle = ExcelData.getData(file_path, "TC01", 1, 2);
		ActiTimeLoginPage lp = new ActiTimeLoginPage(driver);
		lp.verifyTitle(etitle);
		String aversion = lp.verifyVersion();
		String eversion = ExcelData.getData(file_path, "TC03", 1, 0);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(aversion, eversion);
		sa.assertAll();
	}

}
