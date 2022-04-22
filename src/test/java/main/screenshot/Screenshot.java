package main.screenshot;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

;

public class Screenshot {
	public void usingRobot() throws AWTException, IOException {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
	
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		Robot robot = new Robot();
		Rectangle rect = new Rectangle(1920, 1080);
		BufferedImage image = robot.createScreenCapture(rect);
		File file = new File("Robot1.jpg");
		ImageIO.write(image, "jpg", file);

		driver.close();
	}

	public void usingTakeScreenshotSelenium() throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		Thread.sleep(2000);
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		File file = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("UsingSelenium.jpg"+" "+timestamp));
		driver.close();

	}

	public void usingAshot() throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		Thread.sleep(2000);
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		AShot ashot = new AShot();
		ashot.shootingStrategy(ShootingStrategies.viewportPasting(3000));
		ru.yandex.qatools.ashot.Screenshot sc = ashot.takeScreenshot(driver);
		BufferedImage image = sc.getImage();
		ImageIO.write(image, "jpg", new File("ashot.jpg"+timestamp));
		driver.close();
	}
	public void particularElementScreenShot() throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//img[@class='image-image undefined image-hand'])[13]"));
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		File file = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("UsingSelenium.jpg"+" "+timestamp));
		driver.close();
	

	}
	public void fileUpload() throws IOException {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		driver.findElement(By.xpath("//input[@type='file']")).submit();
		Runtime.getRuntime().exec("E:\\Autoitfile\\FileUpload.exe");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("File Successfully Submited");
		driver.close();

	}

	public static void main(String[] args) throws AWTException, IOException, InterruptedException {
		// new Screenshot().usingRobot();
		//new Screenshot().usingTakeScreenshotSelenium();
		//new Screenshot().usingAshot();
		//new Screenshot().particularElementScreenShot();
		new Screenshot().fileUpload();
	}

}
