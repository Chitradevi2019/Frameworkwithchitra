package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.BaseTest;

public class ToDoListPage extends BaseTest {

	// PageFactory -OR 

	@FindBy(xpath = "//h1")
	WebElement todolist_page_title;
	
    @FindBy(id = "plus-icon")  
    WebElement plus_icon;
 
	@FindBy (xpath="//div[@id='container']/input[@placeholder='Add new todo']")
    WebElement add_nu_todo;
	
	
	// Initialize Page Objects
	public ToDoListPage(){ 
	PageFactory.initElements(d , this); //Initializes Elements with value of driver "d" coming from BaseTest
	}
	
	//Actions or Methods
	
	public  String  getPageTitle()// Method1
	{return todolist_page_title.getText();}
	
	public boolean TitleisDispalyed()// Method 2
	{  return todolist_page_title.isDisplayed();
	}
		
	public boolean addNewtodo(String a)
	{
		add_nu_todo.sendKeys(a);
		return (d.findElement(By.xpath("//li[contains(text(), a)]"))).isDisplayed();
	}
		
	public String completeNewtodo(String a)
	{
	    WebElement added_nu_todo = d.findElement(By.xpath("//*[contains(text(), a)]"));
	//    Make sure  newly added to do list is visible and is displayed
	    if (added_nu_todo.isDisplayed()) {
		added_nu_todo.click();  // to complete
		return added_nu_todo.getAttribute("class");
	    }
	    else {
	    	return "Newly Added To Do Item is not present in the list";
	    }
	}
	
	public String deleteNewtodo(String a)
	{
		WebElement added_nu_todo = d.findElement(By.xpath("//*[contains(text(), a)]"));
		WebElement trash_can = d.findElement(By.xpath("//*[contains(text(), a)]/span/i")); 
			//    Make sure  newly added to do list is visible and is displayed
			    if (added_nu_todo.isDisplayed()) {
			        Actions mousehover = new Actions(d);
			        mousehover.moveToElement(added_nu_todo).perform();
         			 trash_can.click();  	 //Click on trash_can to delete
                     return " Deleted Newly Added To do List Item";
			    }
			    else { return " Could not find Added Item in To Do  List: Delete Failed";}
			    	
			    	
			    }
	}
	

	
	

	

