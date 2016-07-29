package com.example.helloandroid.test;

import com.example.helloandroid.MainActivity;
import com.example.helloandroid.R;

import android.app.Instrumentation;
import android.app.Instrumentation.ActivityMonitor;
import android.content.Intent;
import android.os.SystemClock;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author Michael
 * Description: This class is to test MainActivity of HelloAndroid Project, verifying onclick of "Next" button takes user to the second page.
 */

public class TestMainActivity extends ActivityInstrumentationTestCase2<MainActivity> {
    final String TAG = "Test the mainActivity"; 
	private MainActivity mActivity = null;
    private Button button = null;
	private Instrumentation mInstrumentation = null;
	
	public TestMainActivity() {
		super(MainActivity.class);
	}
	
	/*
     * 初始设置
     */
	@Override  
    protected void setUp() throws Exception {
        try {
            super.setUp();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.i(TAG, "call setUp()");
		setActivityInitialTouchMode(false);
		mActivity = getActivity();
        mInstrumentation = getInstrumentation();
        Intent intent = new Intent();
        intent.setClassName("com.example.helloandroid", "com.example.helloandroid.MainActivity");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mActivity = (MainActivity) getInstrumentation().startActivitySync(intent);
        button = (Button) mActivity.findViewById(R.id.btn);
    }
/*	
	public void testPreconditions(){
        assertNotNull(mActivity);
        assertNotNull(button);
    }
    */
    public void testMainActivity() {  
        Log.i(TAG, "Call testMainActivity()");
        assertNotNull(mActivity);
        assertNotNull(button);
        //跳转后的界面的Activity名为com.example.helloandroid.SecondPageActivity
        ActivityMonitor am = getInstrumentation().addMonitor("com.example.helloandroid.SecondPageActivity", null, false);
		SystemClock.sleep(1500);
		mActivity.runOnUiThread(new Runnable() {
			public void run() {
				button.performClick();
			}
		});
		
        am.waitForActivityWithTimeout(5000);//设定等待满足要求的活动创建成功，最多等待5s
        assertEquals(1, am.getHits());//活动创建成功，am.getHits()值为1，否则为0
        System.out.println("成功跳转至第二页！");
        mInstrumentation.waitForIdleSync();
        SystemClock.sleep(5000);        
    }
  
    @Override  
    protected void tearDown() throws Exception {  
    	mActivity.finish();
        try {
            super.tearDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.i(TAG, "tearDown()");
    } 
}