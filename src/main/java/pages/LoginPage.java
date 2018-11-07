package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class LoginPage extends BaseTest {

// PageFactory -OR 

	@FindBy (linkText="Features")
	WebElement features;
	@FindBy (linkText="Sign Up")
	WebElement signupBtn ;
	@FindBy (name="username")
	WebElement username;
	@FindBy (name="password")
	WebElement password;
	@FindBy (xpath="//input[@type='submit']")
	WebElement loginBtn;
	@FindBy (xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmlogo;
	
	// Initialize Page Objects
	public LoginPage(){ 
	PageFactory.initElements(d , this); //Initializes Elements with value of driver "d" coming from BaseTest
	}
	
	//Actions or Methods
	public  String getPageTitle() // Method1
	{ return d.getTitle();}
	
	public boolean getPageLogo() //Method2
	{ return crmlogo.isDisplayed();}
	
	public HomePage login()    //Method3
	{ username.sendKeys(prop.getProperty("username"));    
	  password.sendKeys(prop.getProperty("password"));
	  loginBtn.click();
	  return new HomePage();
	
	}
	
	}
	

