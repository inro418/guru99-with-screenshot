package utils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Guru99ScreenShotTaken {

	WebDriver driver;

	@Test
	public void CaptureScreenshot() throws IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("http://www.demo.guru99.com/V4/");  
		

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(src, new File("./Screenshots/guru99.png"));

		System.out.println("Screenshot taken");

		driver.quit();

	}
}
