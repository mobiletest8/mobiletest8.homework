#mobliletest8.homework.week6
*   [作业1：在本机搭建Appium Grid环境](#hw1)
    *   [1. Prepare the bat file to start up appium grid](#hw1-1)
    *   [2. Prepare the json file for the startup of appium server](#hw1-2)
    *   [3. Prepare the bat file to start up appium server](#hw1-3)
*   [作业2：实现2个以上设备的并行测试](#hw2)
    *   [1. Create a maven project](#hw2-1)
    *   [2. Create a test case class](#hw2-2)
    *   [3. Create 3 devices and related bat file to launch them](#hw2-3)
    *   [4. Create a TestNG xml file to run test in parallel, here it’s  in 3 devices](#hw2-4)
    *   [5. Run test](#hw2-5)
    	
*__Prerequisites:__
JDK, Android SDK, eclipse, appium, maven and their related environment are in place.*  

*__Platform:__ WINDOWS10*

<h2 id="hw1">作业1：在本机搭建Appium Grid环境</h2>		

###<h3 id="hw1-1">1. Prepare the bat file to start up appium grid:</h3>
```bat
@echo off
echo Lanuching appium grid, please wait.
echo Please do not close this window while/after launching.
echo Note: "Selenium Grid hub is up and running" marks the success of lanuching.

java -jar selenium-server-standalone-2.52.0.jar -role hub
```
See [2.Start Up Appium Grid.bat] as well.




###<h3 id="hw1-2">2. Prepare the json file for the startup of appium server:</h3>

```json
{
  "capabilities":
      [
        {
          "browserName": "emulator-5676",
          "version":"4.4.2",
          "maxInstances": 1,
          "platformName":"ANDROID"
        }
      ],
  "configuration":
  {
    "cleanUpCycle":2000,
    "timeout":30000,
    "proxy": "org.openqa.grid.selenium.proxy.DefaultRemoteProxy",
    "url":"http://127.0.0.1:4723/wd/hub",
    "host": "127.0.0.1",
    "port": 4723,
    "maxSession": 1,
    "register": true,
    "registerCycle": 5000,
    "hubPort": 4444,
    "hubHost": "127.0.0.1"
  }
}
```
See [nodeconfig_1.json], [nodeconfig_2.json] and [nodeconfig_3.json] as well.

###<h3 id="hw1-3">3. Prepare the bat file to start up appium server:</h3>

```bat
@echo off
echo Launching appium server, do not close this window, please.
appium -a 127.0.0.1 -p 4723 -bp 4724 --selendroid-port 8090 --chromedriver-port 9515 --session-override --nodeconfig E:\Dev\eclipse\workspace\apppiumtest\grid\nodeconfig_1.json
```
See [3.Start Up Appium Server A.bat], [3.Start Up Appium Server B.bat] and [3.Start Up Appium Server C.bat] as well.

<h2 id="hw2">作业2：实现2个以上设备的并行测试</h2>	


###<h3 id="hw2-1">1. Create a maven project:</h3> 
Create a maven project and add dependencies for TestNG and appium java lib in the pom.xml.

###<h3 id="hw2-2">2. Create a test case class:</h3>

```java
public class TestParallel {
	private AndroidDriver driver;	

	@BeforeClass
	@Parameters({ "udid","deviceName" })
	public void setUp(String udid, String deviceName) throws Exception {
		// set up appium
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "apps");
		File app = new File(appDir, "HelloAndroid.apk");
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
```
See [TestParallel.class] as well.

###<h3 id="hw2-3">3. Create 3 devices and related bat file to launch them:</h3>

1) Create 3 virtual devices.  

2) Create the bat file to launch them:
```bat
@echo off
echo Launching android emulator, please wait...
echo Please do not close the window while/after launching.

start cmd /c emulator -port 5676 -avd appium-test-avd-1
start cmd /c emulator -port 5678 -avd appium-test-avd-2
start cmd /c emulator -port 5680 -avd appium-test-avd-3
```
See [1.Launch AVD.bat] as well.

###<h3 id="hw2-4">4. Create a TestNG xml file to run test in parallel, here it’s  in 3 devices:</h3>

```xml
<?xml version="1.0" encoding="UTF-8"?>
<suite name="Test TestNG Parellel" parallel="tests" thread-count="3">
  <test name="Run test in device 1">
    <parameter name="udid" value="emulator-5676" />
    <parameter name="deviceName" value="appium-test-avd-1" />
    <classes>
      <class name="com.wanmich.apppiumtest.TestParallel"/>
    </classes>
  </test>
  <test name="Run test in device 2">
    <parameter name="udid" value="emulator-5678" />
    <parameter name="deviceName" value="appium-test-avd-2" />
    <classes>
      <class name="com.wanmich.apppiumtest.TestParallel"/>
    </classes>
  </test>
  <test name="Run test in device 3">
    <parameter name="udid" value="emulator-5680" />
    <parameter name="deviceName" value="appium-test-avd-3" />
    <classes>
      <class name="com.wanmich.apppiumtest.TestParallel"/>
    </classes>
  </test>
</suite>

```
See [test-parallel.xml] as well.

###<h3 id="hw2-5">5. Run test:</h3>

Start up avd devices, Appium Grid, Appium Server, then right click against the testng xml file in step 4, select ***Run As > TestNG Suite***.


[1.Launch AVD.bat]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week6/apppiumtest/grid/1.Launch%20AVD.bat
[2.Start Up Appium Grid.bat]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week6/apppiumtest/grid/2.Start%20Up%20Appium%20Grid.bat
[3.Start Up Appium Server A.bat]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week6/apppiumtest/grid/3.Start%20Up%20Appium%20Server%20A.bat
[3.Start Up Appium Server B.bat]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week6/apppiumtest/grid/3.Start%20Up%20Appium%20Server%20B.bat
[3.Start Up Appium Server C.bat]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week6/apppiumtest/grid/3.Start%20Up%20Appium%20Server%20C.bat
[nodeconfig_1.json]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week6/apppiumtest/grid/nodeconfig_1.json
[nodeconfig_2.json]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week6/apppiumtest/grid/nodeconfig_2.json
[nodeconfig_3.json]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week6/apppiumtest/grid/nodeconfig_3.json
[TestParallel.class]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week6/apppiumtest/src/test/java/com/wanmich/apppiumtest/TestParallel.java
[test-parallel.xml]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week6/apppiumtest/src/test/java/test-parallel.xml