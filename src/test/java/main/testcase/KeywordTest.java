package main.testcase;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utility.BaseClass;
import com.utility.Locator;
import com.utility.LocatorType;

import static com.framework.Keyword.*;

public class KeywordTest extends BaseClass {
	private static final Logger Log=Logger.getLogger(KeywordTest.class);
	@Test
	public void tc_01() {
		
		launchURL("https://testingshastra.com/assignments/windowHandlingDemo");
		click(Locator.WindowHandling_ClickMeBtn, LocatorType.Css);
		Log.info("click on click me button");
		switchToWindow("Second Window");
		Log.info("switch to second window");
		String title=driver.getTitle();
		Log.info(title);
		Assert.assertEquals(title, "Testing Shastra | Training | Placement");
		closeBrowser();
		}
}
