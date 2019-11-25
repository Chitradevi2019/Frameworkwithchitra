package util;

import java.io.File;


import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseTest;

public  class Util extends BaseTest{
	
	public static int  PAGE_LOAD_WAIT_TIME = 20;
	public static int  IMPLICIT_WAIT_TIME = 20;
	
	public void switchToFrame()
	{d.switchTo().frame("mainpanel");}


	 public static void takeScreenshotAtEndOfTest() throws IOException {
			File scrFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
			String currentDir = System.getProperty("user.dir");
			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		}

	
		
	}




