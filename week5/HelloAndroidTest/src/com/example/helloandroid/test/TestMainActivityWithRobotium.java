package com.example.helloandroid.test;

import junit.framework.Assert;

import com.example.helloandroid.MainActivity;
import com.example.helloandroid.SecondPageActivity;
import com.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

/**
 * @author Michael
 * @description This test case is the Robotium verion of Instrumentation test case from last week.
 */

@SuppressWarnings("unchecked")
public class TestMainActivityWithRobotium extends ActivityInstrumentationTestCase2<MainActivity> {
	private final String TAG = "Test HelloAndroid with Robotium";
	private static final String TARGET_PACKAGE_ID = "com.example.helloandroid";
	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.example.helloandroid.MainActivity";
	private static Class<?> launcherActivityClass;
	static {
		try {
			launcherActivityClass = Class.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("deprecation")
	public TestMainActivityWithRobotium() throws ClassNotFoundException {
		super(TARGET_PACKAGE_ID, (Class<MainActivity>) launcherActivityClass);
	}

	private Solo solo;

	@Override
	protected void setUp() throws Exception {
		Log.i(TAG, "call setUp()");
		solo = new Solo(getInstrumentation(), getActivity());
	}

	public void testNextButton() {
		Log.i(TAG, "Call testNextButton()");
		solo.assertCurrentActivity("Wrong activity", MainActivity.class);
		solo.clickOnButton("Next");
		//solo.sleep(5000);
		
		/*
		solo.assertCurrentActivity("Wrong activity", SecondPageActivity.class);		
		//check labels and button are displayed.
		boolean expected = true;
		boolean actual = solo.searchText("You are now in the second page.") && solo.searchButton("Back") && solo.searchText("Please touch \"Back\" button if you would like to go back to the first page.");
		assertEquals("You might not land in the second page as the text here is not correct.", expected, actual);
		*/
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
		//solo.sleep(3000);
		
		//solo.goBack();
		solo.clickOnButton("Back");
		/*
		solo.sleep(5000);
		solo.assertCurrentActivity("Wrong activity", MainActivity.class);		
		//check labels and button are displayed.
		boolean expected = true;
		boolean actual = solo.searchText("Hi there! Welcome to HellowAndroid.") && solo.searchText("You are now in the first page. Please touch \"Next\" button if you would like to go back to the second page.");
		assertEquals("You might not land in the first page as the text here is not correct", expected, actual);
		*/
		String activityName = "MainActivity";
		String label1 = "Hi there! Welcome to HellowAndroid.";
		String label2 = "You are now in the first page. Please touch \"Next\" button if you would like to go back to the second page.";
		String buttonName = "Next";
		assertCurrentActivity(activityName, label1, label2, buttonName);
	}
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

	@Override
	public void tearDown() throws Exception {
		Log.i(TAG, "call tearDown()");
		solo.finishOpenedActivities();
	}
}
