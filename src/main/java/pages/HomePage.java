package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class HomePage extends BaseTest {

	
	// PageFactory -OR 

	    @FindBy(xpath = "//td[contains(text(),'User: Ismat Jahan')]")
	    WebElement user;
		@FindBy (xpath = "//a[contains(text(),'Contacts')]")
		WebElement contactsBtn;
		@FindBy(xpath = "//td[contains(text(),'New Contact')]")  
	    WebElement NewContactsLink;
		@FindBy (xpath = "//a[contains(text(),'Deals')]")
        WebElement dealsBtn;
		@FindBy (xpath = "//a[contains(text(),'Tasks')]")
        WebElement tasksBtn;
		
		// Initialize Page Objects
		public HomePage(){ 
		PageFactory.initElements(d , this); //Initializes Elements with value of driver "d" coming from BaseTest
		}
		
		//Actions or Methods
		public String getHomePageTitle()
		{return d.getTitle();}  //Method1
		
		public  boolean getUserName()// Method2
		{return user.isDisplayed();}
		
		public ContactsPage clickContacts() //Method3
		{ contactsBtn.click();
		return new ContactsPage();}
		

		public DealsPage clickDeals() //Method4
		{ dealsBtn.click();
		return new DealsPage();}
		
		
		public TasksPage clickTasks() //Method5
		{ tasksBtn.click();
		return new TasksPage();}
		
		public void clickonNewContactLink()
		{ Actions act = new Actions(d); 
		act.moveToElement(contactsBtn).build().perform();
		NewContactsLink.click();
		
		}
		
		}
	
	
	
	

