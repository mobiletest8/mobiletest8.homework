#mobliletest8.homework.week4
*   [作业1：新建一个app工程：有按钮，多个activity，点击按钮有activity的跳转](#作业1)
    *   [1. 新建一个app，有按钮，多个activity，点击按钮有activity的跳转](#newappproect)
        *   [1) Create one app project in Eclipse](#appproject)
    	*   [2) Prepare the below files:](#prepare)
		    *   [Two Activity Files](#activity)
			*   [The Layout File](#layout)
			*   [The Strings File](#strings)
			*   [The Manifest File](#manifest)
    *   [2. 运行app](#runapp)
*   [作业2：新建一个测试工程：编写测试用例，实现点击按键、activity跳转自动化](#作业2)
    *   [1. 新建一个test工程，编写测试用例，实现点击按键、activity跳转自动化](#newtestproject)
	    *   [1) In Eclipse, follow the option File > New Project and finally select Android Test Project wizard to finish the creation](#testproject)
	    *   [2) Create a test class](#testclass)
	    *   [3) AndroidManifest.xml](#androidmanifest)
    *   [2. 运行测试用例](#runtest)
	    *   [1) Eclipse](#eclipse)
	    *   [2) DevTools](#devtools)
	    *   [3) Command Line Interface](#cli)

		
<h2 id="作业1">作业1：新建一个app工程：有按钮，多个activity，点击按钮有activity的跳转。</h2>		

###<h3 id="newappproect">1. 新建一个app，有按钮，多个activity，点击按钮有activity的跳转。</h3>
####<h4 id="appproject">1) Create one app project in Eclipse:</h4>

In Eclipse, follow the option **File > New Project** and finally select **Android Application Project** wizard to finish the creation:

![alt text][img1-01]    

 
Next, follow the instructions provided and keep all other entries as default thill the final step.


####<h4 id="prepare">2) Prepare the below files:</h4>

![alt text][img1-02]


#####<h5 id="activity">Two Activity Files</h5>

1) [MainActivity.java](https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week4/HelloAndroid/src/com/example/helloandroid/MainActivity.java "MainActivity.java"), where on click listener needs to be set:
```java
@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);//Android生命周期方法
		setContentView(R.layout.activity_main);//设置使用的布局管理器

		final Button btn=(Button)super.findViewById(R.id.btn);
		
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,SecondPageActivity.class);
				startActivity(intent);
			}
		});
```
2) [SecondPageActivity.java](https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week4/HelloAndroid/src/com/example/helloandroid/SecondPageActivity.java "SecondPageActivity.java"), where on click listener needs to be set:
```java
@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);//Android生命周期方法
		setContentView(R.layout.secondpage_main);//设置使用的布局管理器
		
		final Button btn2=(Button)super.findViewById(R.id.btn2);//取得btn2组件/绑定
		btn2.setOnClickListener(new View.OnClickListener() {
			@Override
            public void onClick(View v) {
				SecondPageActivity.this.finish();
            }
		});
	}
```
#####<h5 id="layout">The Layout File</h5>

Add the necessary **TextView/Button** to construct the layout of the app.
Make sure each activity class has a layout file, in my case, they are [activity_main.xml](https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week4/HelloAndroid/res/layout/activity_main.xml "activity_main.xml"):
```xml
<TextView
        android:id="@+id/text1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/firstpage_title" />

    <Button
        android:id="@+id/btn"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:layout_centerVertical="true"
        android:layout_marginTop="152dp"
        android:text="@string/firstpage_btn" />
    
    <TextView
        android:id="@+id/text4"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/btn"
        android:layout_marginTop="55dp"
        android:textColor="#FF0000"
        android:textSize="16sp"
        android:text="@string/firstpage_text" />
```

and [secondpage_main.xml](https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week4/HelloAndroid/res/layout/secondpage_main.xml "secondpage_main.xml"):
```xml
<TextView
        android:id="@+id/text2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textColor="#FF0000"
        android:textSize="16sp"
        android:text="@string/secondpage_title" />
    
    <Button
        android:id="@+id/btn2"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:layout_centerVertical="true"
        android:layout_marginTop="152dp"
        android:text="@string/secondpage_btn" />

    <TextView
        android:id="@+id/text3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/btn2"
        android:layout_marginTop="60dp"
        android:textColor="#ff00ff00"
        android:textSize="16sp"
        android:text="@string/secondpage_text" />
```
#####<h5 id="strings">The Strings File</h5>

In [strings.xml](https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week4/HelloAndroid/res/values/strings.xml "strings.xml"), add the necessary text for TextView/Button for each layout file:
```xml
<string name="app_name">HelloAndroid</string>
    <string name="action_settings">Settings</string>
    <string name="firstpage_title">Hi there! Welcome to HellowAndroid.</string>
    <string name="firstpage_text">You are now in the first page. Please touch \"Next\" button if you would like to go back to the second page.</string>
    <string name="secondpage_title">You are now in the second page.</string>
    <string name="secondpage_text">Please touch \"Back\" button if you would like to go back to the first page.</string>
    
    <string name ="firstpage_btn">Next</string>
    <string name ="secondpage_btn">Back</string>
```

#####<h5 id="manifest">The Manifest File</h5>

Make sure the two created activities are included in the [AndroidManifest.xml](https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week4/HelloAndroid/AndroidManifest.xml "AndroidManifest.xml") file:
```xml
<activity
            android:name=".MainActivity"
            android:label="@string/app_name" >
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
        
        <activity android:name=".SecondPageActivity"></activity>
```

###<h3 id="runapp">2. 运行app</h3>

Before the run of the application, make sure the related one real device or virtual device is in place.  
To run the application from Eclipse, select the project, right click, follow **Run As > Android Application**, the app will be installed on your device and started automatically:
 
![alt text][img1-03]


Click “**Next**”button:
 
![alt text][img1-04]




  [img1-01]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week4/src/common/images/1_01.png
  [img1-02]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week4/src/common/images/1_02.png
  [img1-03]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week4/src/common/images/1_03.png
  [img1-04]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week4/src/common/images/1_04.png
  
  
<h2 id="作业2">作业2：新建一个测试工程：编写测试用例，实现点击按键、activity跳转自动化</h2>
###<h3 id="newtestproject">1. 新建一个test工程，编写测试用例，实现点击按键、activity跳转自动化</h3>
####<h4 id="testproject">1) In Eclipse, follow the option File > New Project and finally select Android Test Project wizard to finish the creation.</h4>

![alt text][img2-01]
 
Select **HelloAndroid** as the test target:

![alt text][img2-02]
 
####<h4 id="testclass">2) Create a test class:</h4>

![alt text][img2-03]
 
Set click button event in [TestMainActivity.java](https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week4/HelloAndroidTest/src/com/example/helloandroid/test/TestMainActivity.java "TestMainActivity.java"):
```java
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
```
####<h4 id="androidmanifest">3) AndroidManifest.xml</h4>

Make sure the below details are included in [AndroidManifest.xml](https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week4/HelloAndroidTest/AndroidManifest.xml "AndroidManifest.xml"):
```xml
<instrumentation
        android:name="android.test.InstrumentationTestRunner"
        android:targetPackage="com.example.helloandroid"
        android:label="HelloAndroid test" />

    <application
        android:icon="@drawable/ic_launcher"
        android:label="@string/app_name" >
        <uses-library android:name="android.test.runner" />
    </application>
```
###<h3 id="runtest">2. 运行测试用例</h3>
####<h4 id="eclipse">1) Eclipse</h4>

In Eclipse, right click on the test project, follow **Run As > Android Junit Test**, instrumentation test will be run in your device.
Before clicking “**Next**” button:

![alt text][img2-04] 

After clicking “**Next**” button:

![alt text][img2-05] 

JUnit View:

![alt text][img2-06] 

Console View:

![alt text][img2-07] 

LogCat View:

![alt text][img2-08]
 
####<h4 id="devtools">2) DevTools</h4>

In device, open DevTools, follow **Instrumentation > HelloAndroid Test**:

![alt text][img2-09]
 
####<h4 id="cli">3) Command Line Interface</h4>

Open cmd, run the below command:

    adb shell am instrument -w com.example.helloandroid.test/android.test.InstrumentationTestRunner

![alt text][img2-10] 



  [img2-01]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week4/src/common/images/1_01.png
  [img2-02]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week4/src/common/images/1_02.png
  [img2-03]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week4/src/common/images/1_03.png
  [img2-04]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week4/src/common/images/1_04.png
  [img2-05]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week4/src/common/images/1_05.png
  [img2-06]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week4/src/common/images/1_06.png
  [img2-07]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week4/src/common/images/1_07.png
  [img2-08]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week4/src/common/images/1_08.png
  [img2-09]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week4/src/common/images/1_09.png
  [img2-10]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week4/src/common/images/1_10.png