package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class HomePage extends BaseTest {

	
	// PageFactory -OR 

	    @FindBy(xpath = "//h1[text()='CONTACT US']")
	    WebElement contact_us;
		@FindBy (xpath = "//h1[text()='LOGIN PORTAL']")
		WebElement login_portal;
		@FindBy(xpath = "//h1[text()='BUTTON CLICKS']")  
	    WebElement button_clicks;
		@FindBy (xpath = "//h1[text()='TO DO LIST']")
        WebElement to_do_list;
		@FindBy (xpath = "//h1[text()='PAGE OBJECT MODEL']")
        WebElement page_object_model;
		@FindBy (xpath = "//h1[text()='ACCORDION @TEXT AFFECTS (APPEAR & DISAPPEAR']")
        WebElement text_affects;
		@FindBy (xpath = "//h1[text()='DROPDOWN, CHECKBOXE(S) & RADIO BUTTON(S)']")
        WebElement dropdown;
		@FindBy (xpath = "//h1[text()='AJAX LOADER']")
        WebElement ajax_loader;
		
		// Initialize Page Objects
		public HomePage(){ 
		PageFactory.initElements(d , this); //Initializes Elements with value of driver "d" coming from BaseTest
		}
		
		//Actions or Methods
		public String getHomePageTitle()
		{return d.getTitle();}  //Method1
		
		public  boolean contactUsisDisplayed()// Method2
		{return contact_us.isDisplayed();}
		
		public  boolean login_PortalisDisplayed()// Method3
		{return login_portal.isDisplayed();}
		
		public  boolean ButtonClicksisDisplayed()// Method4
		{return button_clicks.isDisplayed();}

		public  ButtonClicksPage clickOnButtonClicks()// Method5
		{button_clicks.click();
		return new ButtonClicksPage();}

		public  boolean todolist_isDisplayed()// Method6
		{return to_do_list.isDisplayed();}
		
		public  ToDoListPage clickOnToDoList()// Method7
		{to_do_list.click();
		return new ToDoListPage();}

		public  boolean PageObjectModel_isDisplayed()// Method8
		{return page_object_model.isDisplayed();}
		
		public  PageObjectModelPage clickOnPageObjectModel()// Method9
		{to_do_list.click();
		return new PageObjectModelPage();}
		
		public  boolean Accordion_isDisplayed()// Method10
		{return text_affects.isDisplayed();}
		
		public TextAffectsPage clickOnTextAffects()// Method11
		{text_affects.click();
		return new TextAffectsPage();}
		
		public  boolean Dropdown_isDisplayed()// Method12
		{return dropdown.isDisplayed();}
		
		public DropdownPage clickOnDropdown()// Method13
		{dropdown.click();
		return new DropdownPage();}
		
		public  boolean Ajax_isDisplayed()// Method14
		{return ajax_loader.isDisplayed();}
		
		public AjaxLoaderPage clickOnAjaxLoader()// Method15
		{ajax_loader.click();
		return new AjaxLoaderPage();}
		
		
		}
		
		
	
	
	
	

