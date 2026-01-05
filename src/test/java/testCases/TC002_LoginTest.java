package testCases;

import org.testng.annotations.Test;

import org.testng.Assert;

import pageObjects.HomePage;
import pageObjects.loginPage;
import pageObjects.myAccount;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	@Test(groups= {"Sanity","Master"})
	public void login_verify() {
		logger.info("Starting TC002_LoginTest");
		try {
		HomePage hp=new HomePage(driver);
		hp.click_my_accBtn();
		logger.info("Clickied the My Account ");
		hp.click_login_text();
		logger.info("Clickied the Login ");
		loginPage lp=new loginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.enterPwd(p.getProperty("pwd"));
		lp.clickLogin();
		myAccount ma=new myAccount(driver);
		boolean targetPage=ma.isMyAccountPageExists();
		//Assert.assertEquals(targetPage, true,"Login Failed");
		Assert.assertTrue(targetPage);
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("Ended TC002_LoginTest");
		
		
	}

}
