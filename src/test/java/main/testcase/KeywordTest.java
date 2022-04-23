package main.testcase;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utile.BaseClass;
import com.utile.Locator;
import com.utile.LocatorType;

import static com.framework.Keyword.*;

public class KeywordTest extends BaseClass {
	private static final Logger LOG = Logger.getLogger(KeywordTest.class);

	@Test
	public void tc_01() {

		launchURL("https://testingshastra.com/assignments/windowHandlingDemo");
		click(Locator.WindowHandling_ClickMeBtn, LocatorType.Css);
		LOG.info("click on click me button");
		switchToWindow("Second Window");
		LOG.info("switch to second window");
		String title = driver.getTitle();
		LOG.info(title);
		Assert.assertEquals(title, "Testing Shastra | Training | Placement");
		closeBrowser();
	}
}
