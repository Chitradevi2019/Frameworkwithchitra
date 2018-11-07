package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import util.Util;
import util.WebEventListener;

public class BaseTest {

public static WebDriver  d ;
public static Properties prop;
public static EventFiringWebDriver driver;
public static WebEventListener eventListener;

public    BaseTest() //Constructor
{
	try {
		prop=new Properties();
FileInputStream fis = new FileInputStream("C:\\Users\\Shabbir\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\config\\config.properties");
prop.load(fis);}
   catch (FileNotFoundException e)
{
	e.printStackTrace();
}
    catch (IOException e)
{
	e.printStackTrace();
}
}
public static void initializeDriver() //Method1
{
String browser = prop.getProperty("browsername");
String url = prop.getProperty("url");

	{if (browser.equalsIgnoreCase("chrome"))
	{ d= new ChromeDriver();}
	
	if (browser.equalsIgnoreCase("firefox"))
	{ d= new FirefoxDriver();}
	
	if (browser.equalsIgnoreCase("InternetExplorer"))
	{ d= new InternetExplorerDriver();}
	
	driver = new EventFiringWebDriver(d);

	// Now create object of EventListerHandler to register it with EventFiringWebDriver
	eventListener = new WebEventListener();
driver.register(eventListener);
	d=driver;
	
	d.get(url);
	d.manage().window().maximize();
	d.manage().deleteAllCookies();
	d.manage().timeouts().pageLoadTimeout(Util.PAGE_LOAD_WAIT_TIME,TimeUnit.SECONDS);
	d.manage().timeouts().implicitlyWait(Util.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
	}
}
	
public static void closeBrowser()  //Method2
{
	d.quit();

	
}
	
		
	}
	



