#mobliletest8.homework.week5
*   [作业1：用Robotium去做上周的作业](#作业1)
*   [作业2：新建一个测试工程：编写测试用例，实现点击按键、activity跳转自动化](#作业2)


<h2 id="作业1">作业1：用Robotium去做上周的作业</h2>
Use solo API to rewrite the Instrumentation test cases last week:
```java
    public void testNextButton() {
        Log.i(TAG, "Call testNextButton()");
    	solo.assertCurrentActivity("Wrong activity", MainActivity.class);
		solo.clickOnButton("Next");
		solo.sleep(5000);
		
		solo.assertCurrentActivity("Wrong activity", SecondPageActivity.class);
		
		String activityName = "SecondPageActivity";
		String label1 = "You are now in the second page.";
		String label2 = "Please touch \"Back\" button if you would like to go back to the first page.";
		String buttonName = "Back";
		assertCurrentActivity(activityName, label1, label2, buttonName);
	}
	
	public void testBackButton(){
		Log.i(TAG, "Call testBackButton()");
		solo.assertCurrentActivity("Wrong activity", MainActivity.class);
		solo.clickOnButton("Next");
		solo.sleep(3000);
		
		//solo.goBack();
		solo.clickOnButton("Back");
		solo.sleep(5000);
		solo.assertCurrentActivity("Wrong activity", MainActivity.class);
		String activityName = "MainActivity";
		String label1 = "Hi there! Welcome to HellowAndroid.";
		String label2 = "You are now in the first page. Please touch \"Next\" button if you would like to go back to the second page.";
		String buttonName = "Next";
		assertCurrentActivity(activityName, label1, label2, buttonName);
	}
```
See for [TestActivityWithRobotium.java](https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week5/HelloAndroidTest/src/com/example/helloandroid/test/TestActivityWithRobotium.java "TestActivityWithRobotium.java") details.

**Note:** To run this test case, right click on it or the test project, select Run As > Android JUnit Test.


<h2 id="作业2">作业2：扩展Robotium Solo下面的API，用新API做测试</h2>
I choose to extend assertCurrentActivity with four parameters, in my test case, [TestActivityWithRobotium.java](https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week5/HelloAndroidTest/src/com/example/helloandroid/test/TestActivityWithRobotium.java "TestActivityWithRobotium.java"), I added the below method:

```java
	/**
	 * Asserts that the page matching the specified Activity and labels is active.
	 *
	 * @param activityName the name of the {@link Activity} that is expected to be active. Example is: {@code "MainActivity" or "SecondPageActivity"}
	 * @param label1, label2 the label that is expected to be displayed in the current page
	 * @param buttonName the name of the {@link Button} that is expected to be displayed in the current page
	 */
	public void assertCurrentActivity(String activityName, String label1, String label2, String buttonName) {
		String message1 = "The current Activity is NOT " + "\"" + activityName + "\".";
		String message2 = "\"" + label1 + "\"" + "is NOT found.";
		String message3 = "\"" + label2 + "\"" + "is NOT found.";
		String message4 = "\"" + buttonName + "\"" + "is NOT found.";
		boolean expected = true;
		
		solo.assertCurrentActivity(message1, activityName);
		Assert.assertEquals(message2, expected, solo.searchText(label1));
		Assert.assertEquals(message3, expected, solo.searchText(label2));
		Assert.assertEquals(message4, expected, solo.searchButton(buttonName));		
	}
```

***Note:***  
Please check week4 for `HelloAndroid` project.