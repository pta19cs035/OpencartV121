	package testCases;
	
	import org.testng.annotations.Test;
	
	import org.testng.Assert;

	import pageObjects.HomePage;
	import pageObjects.loginPage;
	import pageObjects.myAccount;
	import testBase.BaseClass;
	import utilities.DataProviders;
	
	public class TC003_LoginDDT extends BaseClass{
		
		@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="Datafriven")//getting data provider from different class
		public void verify_loginDDT(String email,String pwd,String exp) {
			
			logger.info("Starting TC003_LoginDDT");
			try {
			HomePage hp=new HomePage(driver);
			hp.click_my_accBtn();
			logger.info("Clickied the My Account ");
			hp.click_login_text();
			logger.info("Clickied the Login ");
			loginPage lp=new loginPage(driver);
			lp.setEmail(email);
			lp.enterPwd(pwd);
			lp.clickLogin();
			myAccount ma=new myAccount(driver);
			boolean targetPage=ma.isMyAccountPageExists();
			
			if(exp.equalsIgnoreCase("Valid")) {
				if(targetPage==true) {
					ma.clickLogout();
					Assert.assertTrue(true);
					
				}
				else {
					Assert.assertTrue(false);
				}
			}
			if(exp.equalsIgnoreCase("Invalid")) {
				if(targetPage==true) {
					ma.clickLogout();
					Assert.assertTrue(false);
				}else {
					Assert.assertTrue(true);
				}
			}
			} catch(Exception e) {
				Assert.fail();
			}
			logger.info("Finishing TC003_LoginDDT");
		}
	}
