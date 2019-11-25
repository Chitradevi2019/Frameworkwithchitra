package testcases;



import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ToDoListPage;
import pages.ButtonClicksPage;
import pages.HomePage;
import util.Util;

public class HomePageTest extends BaseTest{
	

	HomePage hp;
	Util ute;
	ToDoListPage tdlp ;
	ButtonClicksPage bcp;

	
	public HomePageTest()
	{super();}     //this triggers the try/catch in BaseTest and makes the program read and load .properties file.

	@BeforeClass
	public void setUp()
	
	{         initializeDriver(); 
	ute = new Util();
	hp= new HomePage();


	}
	
	@Test (priority= 1)
public void HomePage_TitleTest()
	{Assert.assertEquals(hp.getHomePageTitle(), "WebDriverUniversity.com");}

	@Test (priority= 2)
public void HomePage_ButtonClicksTest() {
	Assert.assertTrue(hp.ButtonClicksisDisplayed(), "Button Clicks  title is Displayed");		
	}

	@Test (priority= 3)
	public void HomePage_ToDoListTest() {
		Assert.assertTrue(hp.todolist_isDisplayed(), "To Do List  title is Displayed");		
		}
	@Test (priority= 4)
	public void HomePage_PageObjectModelTest() {
		Assert.assertTrue(hp.PageObjectModel_isDisplayed(), "PageObject Model title is Displayed");		
		}
	@Test (priority =5)
	public void HomePage_ButtonsClickLinkTest()
	{System.out.println("Running Button Click Link Test");
	 bcp = hp.clickOnButtonClicks();
	}
	
	
	
	@AfterClass
	public void tearDown()
	{closeBrowser();} 
}
