package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.ToDoListPage;
import util.Util;


public class ToDoListPageTest extends BaseTest{

	HomePage hp;
	Util ute;
	ToDoListPage tdlp ;
	
	public ToDoListPageTest()
	{super();}     //this triggers the try/catch in BaseTest and makes the program read and load .properties file.

	@BeforeClass
	public void setUp()
	
	{         initializeDriver(); 
	ute = new Util();
	hp= new HomePage();
	String parentHandle = driver.getWindowHandle(); // get the current window handle
	tdlp = hp.clickOnToDoList();
	for (String winHandle : driver.getWindowHandles()) {
        driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
    }
	}
	
@Test
public void TDL_TitleTest() {
	System.out.println("Placeholder  for ToDoListPage Title Test");
	Assert.assertEquals(tdlp.getPageTitle(),  "TO-DO LIST");
}

@Test 
public void TDL_AddNewToDoTest() {
	
	System.out.println("Adding New Item to TO DO List");
	Assert.assertTrue(tdlp.addNewtodo("My New To Do Item"));
}


@Test 
public void TDL_CompleteaddedItem() {
	System.out.println("Completing  New Item");
	Assert.assertEquals(tdlp.completeNewtodo("My New To Do Item"), "completed");
}

@Test 
public void TDL_DeleteNewToDoTest() {
	
	System.out.println("Deleteing New Item");
	String message = (tdlp.deleteNewtodo("My New To Do Item"));
	
	System.out.println("Message from   Deleting New Item :   "  +message);

}

	@AfterClass
	public void tearDown()
	{closeBrowser();} 

}