package testcases;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.TasksPage;
import util.Util;

public class HomePageTest extends BaseTest{
	
	LoginPage lp;
	HomePage hp;
	Util ute;
	ContactsPage cp ;
	TasksPage tp;
	
	public HomePageTest()
	{super();}     //this triggers the try/catch in BaseTest and makes the program read and load .properties file.

	@BeforeMethod
	public void setUp()
	
	{         initializeDriver(); 
	ute = new Util();
	lp = new LoginPage();
	hp=lp.login();
	cp = new ContactsPage();
	tp = new TasksPage();
	
	}
	
	@Test (priority= 4)
public void HomePageTitleTest()
	{Assert.assertEquals(hp.getHomePageTitle(), "CRMPRO","Home PageTitle Test Failed");}

	@Test (priority= 5)
public void HomePageUserTitleTest()
{ute.switchToFrame();
Assert.assertTrue(hp.getUserName(), "Home Page does not show appropriate User Name");}

	@Test (priority =6)
	public void ContactsPageLinkTest()
	{System.out.println("Running ContactsPageTest");
	ute.switchToFrame();
	cp = hp.clickContacts() ;
	}
	
	@Test (priority =7)
	public void TasksPageLinkTest()
	{System.out.println("Running TasksPageTest");
		ute.switchToFrame();
	    tp = hp.clickTasks();}
	
	
	
	@AfterMethod
	public void tearDown()
	{closeBrowser();} 
}
