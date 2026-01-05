package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myAccount {
	WebDriver driver;
	public myAccount(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement msgHeading;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement logout;
	
	public boolean isMyAccountPageExists() {
		try {
			Thread.sleep(5000);
		return (msgHeading.isDisplayed());
		}
		catch(Exception e) {
			return false;
		}
	}
	public void clickLogout() {
		logout.click();
	}

}
