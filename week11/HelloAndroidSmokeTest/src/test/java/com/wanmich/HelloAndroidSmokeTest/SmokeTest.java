package com.wanmich.HelloAndroidSmokeTest;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class SmokeTest {
	private AndroidDriver driver;	

	@BeforeClass
	@Parameters({ "udid","deviceName" })
	public void setUp(String udid, String deviceName) throws Exception {
		// set up appium
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "../HelloAndroid/build/outputs/apk");
		File app = new File(appDir, "HelloAndroid-release.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName",deviceName);
		capabilities.setCapability("udid", udid);
		capabilities.setCapability("platformVersion", "4.4");
		// don't add this if apk installation is not necessary
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.example.helloandroid");
		// support Chinese
		capabilities.setCapability("unicodeKeyboard", "True");
		capabilities.setCapability("resetKeyboard", "True");
		// no need sign
		capabilities.setCapability("noSign", "True");
		capabilities.setCapability("appActivity", ".MainActivity");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4444/wd/hub"),capabilities);
	}

	@Test
	public void testNextButton() {
		WebElement nextButton = driver.findElement(By.name("Next"));
		nextButton.click();
		WebElement backButton = driver.findElement(By.id("com.example.helloandroid:id/btn2"));
		String expLabel1 = "You are now in the second page.";
		String expLabel2 = "Please touch \"Back\" button if you would like to go back to the first page.";
		String actLabel1 = driver.findElement(By.id("com.example.helloandroid:id/text2")).getText();
		String actLabel2 = driver.findElement(By.id("com.example.helloandroid:id/text3")).getText();

		assertEquals(expLabel1, actLabel1);
		assertEquals(expLabel2, actLabel2);
		assertTrue(backButton.isDisplayed());
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}
}