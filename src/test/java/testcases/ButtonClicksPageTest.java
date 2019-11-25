package testcases;



import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;

import pages.ButtonClicksPage;
import pages.HomePage;

import util.Util;


public class ButtonClicksPageTest extends BaseTest{
	

	HomePage hp;
	ButtonClicksPage  bcp ;
	Util ute;
   

	
	public ButtonClicksPageTest()
	{super();}     //this triggers the try/catch in BaseTest and makes the program read and load .properties file.

	@BeforeClass()
	public void setUp()
	
	{         initializeDriver(); 


	hp=new HomePage();
	String parentHandle = driver.getWindowHandle(); // get the current window handle
    bcp =hp.clickOnButtonClicks();
    ute = new Util();
    
  
    for (String winHandle : driver.getWindowHandles()) {
        driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
    }
    }
	
	@Test (priority= 1)
       public void ButtonClicks_PageTitleTest()
      {System.out.println("Running Button Clicks Title Test");
       Assert.assertEquals(bcp.getPageTitle(), "WebDriver | Button Clicks");}

	@Test
	public void ButtonClicks_HeaderTest() {
		System.out.println("Running Button Clicks Header Test");
		Assert.assertEquals(bcp.getheaderTitle(), "Lets Get Clicking!");
	}
	
   @Test (priority= 2)
      public void ButtonClicks_WebElementClickTitleTest()
{System.out.println("Checking Title of  WebElement Click");
Assert.assertEquals(bcp.webElementClickTitle(),"WebElement Click");}
   
   @Test (priority =3)
   public void ButtonClicks_JavaScriptTitleTest()
   {System.out.println("Running JavaScript Title Test");
   Assert.assertEquals(bcp.JSClickTitle(),"JavaScript Click");}
   
 
   @Test (priority =4)
   public void ButtonClicks_ActionTitleTest()
   {System.out.println("Running JavaScript Title Test");
   Assert.assertEquals(bcp.ActionClickTitle(),"Action Move & Click");}
   
   @Test (priority =5)
   public void ButtonClicks_webElementClickTest() throws InterruptedException {
	   System.out.println("Click on WebElement CLICK ME! Test");  
	   Thread.sleep(3000);
	   Assert.assertTrue(bcp.clickOnWEclickme());
	   Thread.sleep(2000);
	   
   }
   
   @Test (priority =6)
   public void ButtonClicks_JSClickTest() throws InterruptedException {
	   
	   System.out.println("Click on Java Script CLICK ME!! Test");  
	   Thread.sleep(3000);
	   Assert.assertTrue(bcp.clickOnJSclickme());
	   Thread.sleep(2000);
   }  
   
   @Test(priority =7)
   public void ButtonClicks_ActionMoveClickTest() throws InterruptedException {
	   
	   System.out.println("Click on WebElement CLICK ME! Test");  
	   Thread.sleep(3000);
	   Assert.assertTrue(bcp.clickOnActionMoveClickMe());
	   Thread.sleep(2000);
   }

	@AfterClass
	public void tearDown()
	{closeBrowser();} 
}
