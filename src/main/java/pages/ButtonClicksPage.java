package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;

public class ButtonClicksPage extends BaseTest {

	// PageFactory -OR 

	@FindBy(id="main-header")
    WebElement button_clicks_page_title;
    @FindBy(xpath = "//h2[text()='WebElement Click']")
    WebElement webelement_click_title;
   // @FindBy(xpath = "//*[text()='CLICK ME!']") 
    @FindBy(id="button1")
    WebElement webelement_clickme;   
	@FindBy (xpath = "//h2[text()='JavaScript Click']")
	WebElement javascript_click_title;
//	@FindBy (xpath = "//*[text()='CLICK ME!!']")
	@FindBy(id="button2")
	WebElement javascript_clickme;
	@FindBy(xpath = "//h2[text()='Action Move & Click']") 
	WebElement action_click_title;
//	@FindBy (xpath = "//*[text()='CLICK ME!!!']")
	@FindBy(id="button3")
	WebElement action_clickme;
	@FindBy (xpath="//h4[text()='Congratulations!']")
    WebElement webelement_modal_title;
	@FindBy (xpath = "(//button[text()='Close'])[1]")
    WebElement WE_modal_close;
	@FindBy (xpath = "//h4[text()='It’s that Easy!!  Well I think it is.....']")
    WebElement  jsclick_modal_title;
	@FindBy (xpath = "(//button[text()='Close'])[2]")
    WebElement JS_modal_close;
	@FindBy (xpath = "//h4[text()='Well done! the ']")
    WebElement action_move_modal_title;
	@FindBy (xpath = "(//button[text()='Close'])[3]")
    WebElement action_modal_close;
	@FindBy (xpath = "//footer/div/div/p")
    WebElement footer_text;

	
	// Initialize Page Objects
	public ButtonClicksPage(){ 
	PageFactory.initElements(d , this); //Initializes Elements with value of driver "d" coming from BaseTest
	}
	
	//Actions or Methods
	public String getPageTitle()
	{return d.getTitle();}  //Method1
	
	public String getheaderTitle()
	{return button_clicks_page_title.getText();
	}
	
	public  boolean webElementClickisDisplayed()// Method2
	{return webelement_click_title.isDisplayed();}
	
	public  String webElementClickTitle()// Method3
	{return webelement_click_title.getText();}
	
	public  boolean JSClickisDisplayed()// Method4
    {return javascript_click_title.isDisplayed();}
	
	public  String JSClickTitle()// Method5
    {return javascript_click_title.getText();}
	
	public  boolean actionMoveisDisplayed()// Method6
	{return action_click_title.isDisplayed();}
	
	public  String ActionClickTitle()// Method7
    {return action_click_title.getText();}

	public  boolean clickOnWEclickme() throws InterruptedException// Method8
	{webelement_clickme.click();
	Thread.sleep(3000);
	boolean isSeen =  webelement_modal_title.isDisplayed();
	WE_modal_close.click();
	return isSeen;
	}

	public  boolean clickOnJSclickme() throws InterruptedException// Method9
	{javascript_clickme.click();
	Thread.sleep(3000);
	boolean isSeen =  jsclick_modal_title.isDisplayed();
	JS_modal_close.click();
	return isSeen;}
	
	public  boolean  clickOnActionMoveClickMe() throws InterruptedException// Method10
	{action_clickme.click();
	Thread.sleep(3000);
	boolean isSeen= action_move_modal_title.isDisplayed()  ;
	action_modal_close.click();
	return isSeen;
	}
     

	public  String  getFooterText() //Method 12
	{return footer_text.getText();
	}
	
}
