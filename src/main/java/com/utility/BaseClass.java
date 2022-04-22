package com.utility;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static com.framework.Keyword.*;

public class BaseClass {

	@BeforeMethod
	public void setup() {
		openBrowser("Chrome");
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
