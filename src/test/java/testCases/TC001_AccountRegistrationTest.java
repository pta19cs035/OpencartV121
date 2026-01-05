package testCases;



import org.testng.annotations.Test;

import org.testng.Assert;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups= {"Regression","Master"})
	void verify_account_registration() {
		logger.info("Starting TC001_AccountRegistrationTest");
		try {
		HomePage hp=new HomePage(driver);
		hp.click_my_accBtn();
		logger.info("Clicked Account Link");
		hp.click_Reg_btn();
		logger.info("Clciked Register Link");
		RegistrationPage rp=new RegistrationPage(driver);
		logger.info("Providing customer details");
		rp.enterFirstName(randomeString().toUpperCase());
		rp.enterLastName(randomeString().toUpperCase());
		rp.enterEmail(randomeString()+"@gmail.com");
		rp.entertelePhone(randomeNumber());
		String password=randomeAlphanumeric();
		rp.enterpwd(password);
		rp.confirmPwd(password);
		rp.click_agree_checkBox();
		rp.click_cont();

		String confmsg=rp.visibleheading();
		if(confmsg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}
		else {
			logger.error("Testing Failed");
			logger.debug("Debug Logs");
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("Finished TC001_AccountRegistrationTest");
	}

	


}
