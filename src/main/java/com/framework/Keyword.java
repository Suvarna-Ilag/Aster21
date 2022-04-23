package com.framework;

import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.messages.internal.com.google.protobuf.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Keyword {
	public static RemoteWebDriver driver;
	public static WebDriverWait wait;
	private static final Logger LOG = Logger.getLogger(Keyword.class);

	public static void openBrowser(String browserName) {

		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			LOG.info("Chrome Browser is started");
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			LOG.info("IE Browser is started");
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new ChromeDriver();
			LOG.info("Firefox Browser is started");
			break;
		default:
			LOG.error("Invalid browser name " + browserName);
			break;
		}
		wait = new WebDriverWait(driver, 30000);

	}

	public static void launchURL(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		LOG.info("launching url:" + url);
	}

	private static WebElement getWebElement(String locator, String locatorType) {
		WebElement element = null;
		if (locatorType.equalsIgnoreCase("xpath")) {
			element = driver.findElement(By.xpath(locator));

		} else if (locatorType.equalsIgnoreCase("css")) {
			element = driver.findElement(By.cssSelector(locator));

		} else if (locatorType.equalsIgnoreCase("id")) {
			element = driver.findElement(By.id(locator));

		} else if (locatorType.equalsIgnoreCase("class")) {
			element = driver.findElement(By.className(locator));

		} else if (locatorType.equalsIgnoreCase("linkText")) {
			element = driver.findElement(By.linkText(locator));

		} else if (locatorType.equalsIgnoreCase("partialLinkText")) {
			element = driver.findElement(By.partialLinkText(locator));

		} else if (locatorType.equalsIgnoreCase("tagName")) {
			element = driver.findElement(By.tagName(locator));

		} else {
			LOG.error("Invalid locatorType " + locatorType);
		}

		return element;

	}

	public static void click(String locator, String locatorType) {
		getWebElement(locator, locatorType).click();

	}

	public static void enterText(String locator, String locatorType, String text) {
		getWebElement(locator, locatorType).sendKeys(text);
	}

	public static void switchToWindow(String windowTitle) {
		Set<String> allHandles = driver.getWindowHandles();
		for (String handle : allHandles) {
			if (driver.switchTo().window(handle).getTitle().equalsIgnoreCase(windowTitle)) {
				break;
			}
		}
	}

	public static void switchToFrame() {
		driver.switchTo().frame(0);

	}

	public static String getTextOfElement(String locator, String locatorType) {
		return getWebElement(locator, locatorType).getText();
	}

	public static void waitFor(long duration) {
		try {
			wait.wait(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		;
	}

}
