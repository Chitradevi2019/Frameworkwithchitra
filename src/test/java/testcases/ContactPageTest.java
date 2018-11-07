package testcases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;
import util.Util;


public class ContactPageTest extends BaseTest{
	
	LoginPage lp;
	HomePage hp;
	ContactsPage cp ;
	Util ute;
   

	
	public ContactPageTest()
	{super();}     //this triggers the try/catch in BaseTest and makes the program read and load .properties file.

	@BeforeMethod()
	public void setUp()
	
	{         initializeDriver(); 

	lp = new LoginPage();
	hp=lp.login();
	cp = new ContactsPage();
    ute = new Util();
    ute.switchToFrame();
	cp= hp.clickContacts();
	
	
	}
	
	@Test (priority= 8)
public void ContactPageTitleTest()
     {System.out.println("Running Contact Page Title Test");
	Assert.assertTrue(cp.getContactsLabel(), "Contact Page Launch Failed");}

	@Test (priority= 9)
public void OwnerNameTest()
{System.out.println("Running OwnerName Test");
Assert.assertTrue(cp.getOwnerName(), "Page does not contain Owner Name");}

	@Test (priority =10)
	public void SelectContactbyName()
	{System.out.println("Selecting Single Contact by Name");
	cp.SelectContactbyName("Shabbir Ahmed");}
	

/*	@Test (priority =11)
	public void SelectMultipleContactbyName()
	{System.out.println("Selecting multiple Contact by Name");
	
	cp.SelectContactbyName("Shabbir Ahmed");
	cp.SelectContactbyName("Shayan Ahmed");} */

	
	@Test (priority =12, dataProvider="getData")
	public void CreateNewContact(String title, String fname, String lname,String email, String company )
	{
		System.out.println(title+fname+lname);
	 { cp.createNewContact(title, fname, lname, email, company);}}
	
	@DataProvider
	
	public Object[][] getData() throws IOException
	{
	String Excelpath = "C:\\Users\\Shabbir\\FreeCRMAppTest.xlsx";
	String SheetName = "Contacts";
	Object[][] data =Util.getTestData(Excelpath, SheetName);
	return data;

	}
	
	
	@AfterMethod
	public void tearDown()
	{closeBrowser();} 
}
