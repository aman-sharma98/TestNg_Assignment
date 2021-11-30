package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import test.Baseclass;

public class LoginPage {
	
	WebDriver driver = Baseclass.driver;
	ExtentTest test = Baseclass.test;
	
	//=====WebElement=====
	
	@FindBy(id="user-name")
	WebElement UserName;
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(name="login-button")
	WebElement LoginButton;
	
	@FindBy(tagName="h3")
	WebElement Error;
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	
	}
	
	//=====Methods=====
	
	public void Login(String UName, String Pwd) {
		
		//WebDriverWait wait = new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.visibilityOf(LoginLink));
		
		
		UserName.sendKeys(UName);
		test.log(LogStatus.PASS, "Enter UserName "+UName, "Successfully Entered UserName");
		
		Password.sendKeys(Pwd);
		test.log(LogStatus.PASS, "Enter Password "+Pwd, "Successfully Entered Password");
		
		LoginButton.click();
		test.log(LogStatus.PASS, "Click on Login Button", "Clicked on Login Button");
		
	}

	public void ErrorCheck() {
		
		String ActualMsg = Error.getText();
		String ExpectedMsg = "Epic sadface: Username and password do not match any user in this service";
		
		//Assert.assertEquals(ActualMsg, ExpectedMsg);

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(ActualMsg, ExpectedMsg);
		soft.assertAll();
	}
	
}