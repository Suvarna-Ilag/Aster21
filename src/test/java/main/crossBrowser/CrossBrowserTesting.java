package main.crossBrowser;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserTesting {
	RemoteWebDriver driver;

	@BeforeMethod
	public void setUp() {
		//WebDriverManager.firefoxdriver().setup();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}
	@Test
	public void m1() {
		System.out.println("m1");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
