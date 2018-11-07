package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.BaseTest;

public class ContactsPage extends BaseTest {

	// PageFactory -OR 
String contact2name = prop.getProperty("contact2");

    @FindBy(xpath = "//td[contains(text(),'Contacts')]")  
    WebElement contactslabel;
    
    
  
	@FindBy (name="Shabbir Ahmed")
    WebElement contact2;
	
	@FindBy (id= "first_name")
	WebElement fname;
	
	@FindBy (id= "surname")
	WebElement ltname;
	
	@FindBy (id= "email")
	WebElement email;
	
	@FindBy (name= "client_lookup")
	WebElement companyname;
	
	@FindBy (xpath="//input[@value='Save']")
	WebElement saveBtn;
	
	// Initialize Page Objects
	public ContactsPage(){ 
	PageFactory.initElements(d , this); //Initializes Elements with value of driver "d" coming from BaseTest
	}
	
	//Actions or Methods
	
	public  boolean getContactsLabel()// Method1
	{return contactslabel.isDisplayed();}
	
	public boolean getOwnerName()// Method 2
	{  String name = d.findElement(By.xpath("//*[@id='extendedSearchLayer']/table/tbody/tr[2]/td[2]/table	/tbody/tr/td[2]")).getText();
	boolean b = name.contains("Ismat");
	return b;		}
	
	public  boolean Contact1() //Method3
	{ boolean b= d.findElement(By.xpath("//form[id='vContactsForm']/table/tbody/tr[5]/td[2]/a")).getText().startsWith("Shabbir");
		return b;}
	
	public void  SelectContactbyName(String name)//Method 4
	{ 	
	// d.findElement(By.xpath("//a[contains(text(),'"+name+"')]/parent::td/preceding-sibling::td/input")).clear();
	d.findElement(By.xpath("//a[contains(text(),'"+name+"')]/parent::td/preceding-sibling::td/input")).click();
	}

	public void createNewContact(String Title,String FirstName, String LastName, String eMail, String CompanyName)
	{ // go to new contact form
		
		WebElement element =d.findElement(By.xpath("//a[@title='Contacts']/parent::li/ul/li/a[@title='New Contact']"));
  JavascriptExecutor js = (JavascriptExecutor)d;
    js.executeScript("arguments[0].click();", element);    //To click on hidden element use java script executor	
		
		
//Select Title from drop down menu of Title
		
		Select sel = new Select(d.findElement(By.name("title")));
		sel.selectByVisibleText( Title);
		
	fname.sendKeys(FirstName);
	ltname.sendKeys(LastName);
	email.sendKeys(eMail);
	companyname.sendKeys(CompanyName);
	saveBtn.click();
	}
	
}
	

