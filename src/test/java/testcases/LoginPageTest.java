package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageTest extends BaseTest{
	
	LoginPage lp;
	HomePage hp;
	public LoginPageTest()
	{super();}     //this triggers the try/catch in BaseTest and makes the program read and load .properties file.

	@BeforeMethod
	public void setUp()
	
	{         initializeDriver();   
	lp = new LoginPage();
	}
	
	@Test (priority= 1)
public void LoginPageTitleTest()
	{Assert.assertEquals(lp.getPageTitle(), "#1 Free CRM software in the cloud for sales and service");}

	@Test (priority= 2)
public void LoginPageLogoTest()
{boolean flag = lp.getPageLogo();
Assert.assertTrue(flag);
}

	@Test (priority= 3)
	public void ValidateLoginTest()
	{ hp = lp.login();
	
	}
	
	@AfterMethod
	public void tearDown()
	{closeBrowser();} 
}
