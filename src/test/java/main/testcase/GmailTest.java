package main.testcase;

import org.testng.annotations.Test;

import static com.framework.Keyword.*;
import com.utility.BaseClass;

public class GmailTest extends BaseClass {

	@Test
	public void tc_01() {
		openBrowser("Chrome");
		launchURL("https://www.google.com/intl/en_in/gmail/about/");
		click("//a[@class=\"h-c-button h-c-header__cta-li-link h-c-header__cta-li-link--primary\"]", "xpath");
		switchToWindow("Create your Google Account");
		enterText("input#firstName", "css", "Testing");
		enterText("input#lastName", "css", "Shastra");
		enterText("input#username", "css", "Test123");
		enterText("//input[@name=\"Passwd\"]", "xpath", "Testing@123");
		enterText("//input[@name=\"ConfirmPasswd\"]", "xpath", "Testing@123");
		click("//span[text()='Next']", "xpath");
		switchToFrame();
		enterText("//div[text()='Phone number']", "xpath", "1234567890");
		closeBrowser();

	}
}
