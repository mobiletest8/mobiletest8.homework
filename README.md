#mobliletest8.homework.week2
*   [作业1：Android各个工具的使用](#作业1)
    *   [ddms.bat](#ddms)
    *   [hierarchyviewer.bat](#hierarchyviewer)
    *   [emulator.bat](#emulator)
    *   [uiautomatorviewer.bat](#uiautomatorviewer)
*   [作业2：adb各个命令](#作业2)
    *   [adb Install, uninstall](#installuninstall)
    *   [adb logcat](#logcat)
    *   [adb push, pull, ls, rm, mkdir](#pushpulletc)
    *   [adb shell dumpsys meminfo <package name>](#meminfo)
    *   [adb shell input keyevent](#input)
    *   [adb shell am start packagename/activityname](#amstart)
    *   [adb shell monkey](#monkey)
*   [作业3：Monkey三种不同策略的脚本并阐述策略](#作业3)
    *   [Monkey命令一](#monkeycommand1)
	*   [Monkey命令二](#monkeycommand2)
	*   [Monkey命令三](#monkeycommand3)
	
<h2 id="作业1">作业1：Android各个工具的使用</h2>
###<h3 id="ddms">ddms.bat</h3>
1. Launch ddms.bat and select com.basecap.bc3:  
![alt text][img01]
2. Add a new logcat filter:  
![alt text][img02]
3. Select the new logcat filter:  
![alt text][img03]  


  [img01]: https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png
  [img02]: https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png
  [img03]: https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png
 

###<h3 id="hierarchyviewer">hierarchyviewer.bat</h3>  
1. Launch hierarchyviewer.bat:  
![alt text][img04]
2. Inspect Screenshot  
![alt text][img05]
3. Log in command line:  
![alt text][img06]


  [img04]: https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png  
  [img05]: https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png  
  [img06]: https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png

###<h3 id="emulator">emulator.bat</h3>  
![alt text][img07]  


  [img07]: https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png  
 

###<h3 id="uiautomatorviewer">uiautomatorviewer.bat</h3>
![alt text][img08]  
![alt text][img09]


  [img08]: https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png
  [img09]: https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png

  
<h2 id="作业2">作业2：adb各个命令</h2>
###<h3 id="installuninstall">adb Install, uninstall</h3>
![alt text][img10]


  [img10]: https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png

###<h3 id="logcat">adb logcat</h3>
![alt text][img11]  
![alt text][img12]


  [img11]: https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png
  [img12]: https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png


###<h3 id="pushpulletc">adb push, pull, ls, rm, mkdir</h3>
![alt text][img13]


  [img13]: https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png


###<h3 id="meminfo">adb shell dumpsys meminfo <package name></h3>
![alt text][img14]


   [img14]: https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png



###<h3 id="amstart">adb shell am start packagename/activityname</h3>
###<h3 id="input">adb shell input keyevent</h3>
![alt text][img15]  
![alt text][img16]


  [img15]: https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png
  [img16]: https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png

###<h3 id="monkey">adb shell monkey</h3>
![alt text][img17]


  [img17]: https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png

<h2 id="作业3">作业3：Monkey三种不同策略的脚本并阐述策略</h2>
<h3 id="monkeycommand1">Monkey命令一</h3>

    adb shell monkey -v 50
***策略阐述：***  

	在默认设备上，向全部安装包任意发送50个伪随机事件，其中各事件的比例随机分配，打印信息的详细级别:level 0(-v)。

***详细打印信息：***
>C:\Users\Michael>adb shell monkey -v 50
WARNING: linker: libdvm.so has text relocations. This is wasting memory and is a security risk. Please fix.
:Monkey: seed=1465934000638 count=50
:IncludeCategory: android.intent.category.LAUNCHER
:IncludeCategory: android.intent.category.MONKEY
// Event percentages:
//   0: 15.0%
//   1: 10.0%
//   2: 2.0%
//   3: 15.0%
//   4: -0.0%
//   5: 25.0%
//   6: 15.0%
//   7: 2.0%
//   8: 2.0%
//   9: 1.0%
//   10: 13.0%
:Switch: #Intent;action=android.intent.action.MAIN;category=android.intent.category.LAUNCHER;launchFlags=0x10200000;component=com.android.development/.Development;end
    // Allowing start of Intent { act=android.intent.action.MAIN cat=[android.intent.category.LAUNCHER] cmp=com.android.development/.Development } in package com.android.development
:Sending Touch (ACTION_DOWN): 0:(542.0,1611.0)
:Sending Touch (ACTION_UP): 0:(532.0447,1616.48)
:Sending Touch (ACTION_DOWN): 0:(539.0,1077.0)
:Sending Touch (ACTION_UP): 0:(544.11487,1077.675)
:Sending Touch (ACTION_DOWN): 0:(932.0,176.0)
:Sending Touch (ACTION_UP): 0:(918.43097,176.2825)
:Sending Touch (ACTION_DOWN): 0:(350.0,564.0)
:Sending Touch (ACTION_UP): 0:(403.63956,654.00165)
:Sending Touch (ACTION_DOWN): 0:(640.0,568.0)
:Sending Touch (ACTION_UP): 0:(666.5101,533.5245)
    // Allowing start of Intent { act=android.intent.action.MAIN cat=[android.intent.category.TEST] cmp=com.android.development/.ConfigurationViewer } in package com.android.development
:Sending Touch (ACTION_DOWN): 0:(35.0,1056.0)
:Sending Touch (ACTION_UP): 0:(46.650333,1070.8444)
:Sending Touch (ACTION_DOWN): 0:(92.0,843.0)
Events injected: 50
:Sending rotation degree=0, persist=false
:Dropped: keys=0 pointers=4 trackballs=0 flips=0 rotations=0  
\## Network stats: elapsed time=4079ms (0ms mobile, 0ms wifi, 4079ms not connected)  
// Monkey finished


<h3 id="monkeycommand2">Monkey命令二</h3>

	adb -s emulator-5554 shell monkey -p com.basecamp.bc3 --pct-motion 30 --pct-touch 10 --pct-trackball 2 --pct-appswitch 15 --ignore-crashes --ignore-timeouts --throttle 500 -v -v -v 50
***策略阐述：***  

	在设备emulator-5554上启动应用程序（package: com.basecamp.bc3），向其发送50个伪随机事件，  
	其中各事件的百分比为:  
	触摸事件(touch)：10%  
	滑动事件(motion)：30%  
	轨迹球事件(trackball)：2%  
	调整启动Activity(appswitch)：15%  
	其它事件：43%  
	事件间隔时间(throttle)：500 ms  
	打印信息的详细级别:level 2(-v -v -v)  
	忽略任何程序崩溃/失控异常(--ignore-crashes)、超时错误(--ignore-timeouts)。

***详细打印信息：***
>C:\Users\Michael>adb -s emulator-5554 shell monkey -p com.basecamp.bc3 --pct-motion 30 --pct-touch 10 --pct-trackball 2 --pct-appswitch 15 --ignore-crashes --ignore-timeouts --throttle 500 -v -v -v 50
WARNING: linker: libdvm.so has text relocations. This is wasting memory and is a security risk. Please fix.
:Monkey: seed=1465932180290 count=50
:AllowPackage: com.basecamp.bc3
:IncludeCategory: android.intent.category.LAUNCHER
:IncludeCategory: android.intent.category.MONKEY
// Selecting main activities from category android.intent.category.LAUNCHER
//   - NOT USING main activity com.android.contacts.activities.PeopleActivity (from package com.android.contacts)
//   - NOT USING main activity com.android.dialer.DialtactsActivity (from package com.android.dialer)
//   - NOT USING main activity com.android.mms.ui.ConversationList (from package com.android.mms)
//   - NOT USING main activity com.android.settings.Settings (from package com.android.settings)
//   - NOT USING main activity com.android.browser.BrowserActivity (from package com.android.browser)
//   - NOT USING main activity com.android.calculator2.Calculator (from package com.android.calculator2)
//   - NOT USING main activity com.android.calendar.AllInOneActivity (from package com.android.calendar)
//   - NOT USING main activity com.android.deskclock.DeskClock (from package com.android.deskclock)
//   - NOT USING main activity com.android.email.activity.Welcome (from package com.android.email)
//   - NOT USING main activity com.android.camera.GalleryPicker (from package com.android.gallery)
//   - NOT USING main activity com.android.camera.Camera (from package com.android.camera)
//   - NOT USING main activity com.android.music.MusicBrowserActivity (from package com.android.music)
//   - NOT USING main activity com.example.android.apis.ApiDemos (from package com.example.android.apis)
//   - NOT USING main activity com.android.gesture.builder.GestureBuilderActivity (from package com.android.gesture.builder)
//   - NOT USING main activity com.android.widgetpreview.WidgetPreviewActivity (from package com.android.widgetpreview)
//   - NOT USING main activity com.android.customlocale2.CustomLocaleActivity (from package com.android.customlocale2)
//   - NOT USING main activity com.android.development.Development (from package com.android.development)
//   - NOT USING main activity android.app.AliasActivity (from package com.android.development_settings)
//   - NOT USING main activity com.android.providers.downloads.ui.DownloadList (from package com.android.providers.downloads.ui)
//   - NOT USING main activity com.android.quicksearchbox.SearchActivity (from package com.android.quicksearchbox)
//   - NOT USING main activity com.android.speechrecorder.SpeechRecorderActivity (from package com.android.speechrecorder)
//   - NOT USING main activity com.zhihu.android.app.ui.activity.MainActivity (from package com.zhihu.android)
//   - NOT USING main activity io.appium.settings.Settings (from package io.appium.settings)
//   - NOT USING main activity io.appium.unlock.Unlock (from package io.appium.unlock)
//   + Using main activity com.basecamp.bc3.activities.MyStuffActivity (from package com.basecamp.bc3)
// Selecting main activities from category android.intent.category.MONKEY
//   - NOT USING main activity com.android.launcher2.Launcher (from package com.android.launcher)
//   - NOT USING main activity com.android.settings.Settings$RunningServicesActivity (from package com.android.settings)
//   - NOT USING main activity com.android.settings.Settings$StorageUseActivity (from package com.android.settings)
// Seeded: 1465932180290
// Event percentages:
//   0: 10.0%
//   1: 30.0%
//   2: 1.4827586%
//   3: 2.0%
//   4: -0.0%
//   5: 18.534483%
//   6: 11.120689%
//   7: 1.4827586%
//   8: 15.0%
//   9: 0.7413793%
//   10: 9.637931%
:Switch: #Intent;action=android.intent.action.MAIN;category=android.intent.category.LAUNCHER;launchFlags=0x10200000;component=com.basecamp.bc3/.activities.MyStuffActivity;end
    // Allowing start of Intent { act=android.intent.action.MAIN cat=[android.intent.category.LAUNCHER] cmp=com.basecamp.bc3/.activities.MyStuffActivity } in package com.basecamp.bc3
Sleeping for 500 milliseconds
    // Allowing start of Intent { cmp=com.basecamp.bc3/.activities.AuthChooserActivity } in package com.basecamp.bc3
    // activityResuming(com.basecamp.bc3)
:Sending Key (ACTION_DOWN): 23    // KEYCODE_DPAD_CENTER
:Sending Key (ACTION_UP): 23    // KEYCODE_DPAD_CENTER
Sleeping for 500 milliseconds
:Sending Touch (ACTION_DOWN): 0:(475.0,607.0)
:Sending Touch (ACTION_MOVE): 0:(478.90558,606.65015)
:Sending Touch (ACTION_MOVE): 0:(479.71854,605.7405)
:Sending Touch (ACTION_MOVE): 0:(485.85208,604.69055)
:Sending Touch (ACTION_MOVE): 0:(486.3865,603.2086)
:Sending Touch (ACTION_UP): 0:(494.13705,601.9143)
Sleeping for 500 milliseconds
:Sending Key (ACTION_DOWN): 19    // KEYCODE_DPAD_UP
:Sending Key (ACTION_UP): 19    // KEYCODE_DPAD_UP
Sleeping for 500 milliseconds
:Sending Touch (ACTION_DOWN): 0:(666.0,574.0)
:Sending Touch (ACTION_MOVE): 0:(665.1361,572.88464)
:Sending Touch (ACTION_MOVE): 0:(652.46466,571.9489)
:Sending Touch (ACTION_MOVE): 0:(639.1491,571.83673)
:Sending Touch (ACTION_MOVE): 0:(626.6052,571.30054)
:Sending Touch (ACTION_MOVE): 0:(624.42896,570.8348)
:Sending Touch (ACTION_MOVE): 0:(621.0069,569.60565)
:Sending Touch (ACTION_MOVE): 0:(608.564,568.9186)
:Sending Touch (ACTION_MOVE): 0:(608.2914,568.7675)
:Sending Touch (ACTION_MOVE): 0:(596.2092,567.6189)
:Sending Touch (ACTION_UP): 0:(584.229,567.15234)
Sleeping for 500 milliseconds
:Sending Key (ACTION_DOWN): 20    // KEYCODE_DPAD_DOWN
:Sending Key (ACTION_UP): 20    // KEYCODE_DPAD_DOWN
Sleeping for 500 milliseconds
:Switch: #Intent;action=android.intent.action.MAIN;category=android.intent.category.LAUNCHER;launchFlags=0x10200000;component=com.basecamp.bc3/.activities.MyStuffActivity;end
    // Allowing start of Intent { act=android.intent.action.MAIN cat=[android.intent.category.LAUNCHER] cmp=com.basecamp.bc3/.activities.MyStuffActivity } in package com.basecamp.bc3
Sleeping for 500 milliseconds
    // Allowing start of Intent { cmp=com.basecamp.bc3/.activities.AuthChooserActivity } in package com.basecamp.bc3
    // activityResuming(com.basecamp.bc3)
:Sending Touch (ACTION_DOWN): 0:(684.0,1170.0)
:Sending Touch (ACTION_MOVE): 0:(689.8101,1170.8035)
:Sending Touch (ACTION_UP): 0:(690.4479,1171.514)
Sleeping for 500 milliseconds
:Sending Touch (ACTION_DOWN): 0:(648.0,1773.0)
:Sending Touch (ACTION_UP): 0:(657.2271,1776.0)
Sleeping for 500 milliseconds
:Sending Key (ACTION_DOWN): 21    // KEYCODE_DPAD_LEFT
:Sending Key (ACTION_UP): 21    // KEYCODE_DPAD_LEFT
Sleeping for 500 milliseconds
:Sending Touch (ACTION_DOWN): 0:(796.0,505.0)
:Sending Touch (ACTION_MOVE): 0:(790.79535,504.97928)
:Sending Touch (ACTION_UP): 0:(771.3353,504.9201)
Sleeping for 500 milliseconds
:Sending Touch (ACTION_DOWN): 0:(344.0,665.0)
:Sending Touch (ACTION_MOVE): 0:(353.42615,659.2759)
:Sending Touch (ACTION_MOVE): 0:(359.70676,647.73193)
:Sending Touch (ACTION_MOVE): 0:(376.35425,643.6827)
:Sending Touch (ACTION_MOVE): 0:(385.76996,636.524)
:Sending Touch (ACTION_MOVE): 0:(389.7779,626.3165)
:Sending Touch (ACTION_MOVE): 0:(397.1595,623.12646)
:Sending Touch (ACTION_MOVE): 0:(398.28256,620.96655)
:Sending Touch (ACTION_UP): 0:(408.2776,611.6442)
Sleeping for 500 milliseconds
:Sending Key (ACTION_DOWN): 19    // KEYCODE_DPAD_UP
:Sending Key (ACTION_UP): 19    // KEYCODE_DPAD_UP
Sleeping for 500 milliseconds
:Sending Touch (ACTION_DOWN): 0:(527.0,1151.0)
:Sending Touch (ACTION_UP): 0:(522.853,1135.6967)
Sleeping for 500 milliseconds
:Sending Key (ACTION_DOWN): 19    // KEYCODE_DPAD_UP
:Sending Key (ACTION_UP): 19    // KEYCODE_DPAD_UP
Events injected: 50
:Sending rotation degree=0, persist=false
:Dropped: keys=0 pointers=0 trackballs=0 flips=0 rotations=0  
\## Network stats: elapsed time=7872ms (0ms mobile, 0ms wifi, 7872ms not connected)  
// Monkey finished


<h3 id="monkeycommand3">Monkey命令三</h3>
	
	adb -s emulator-5554 shell monkey -p com.basecamp.bc3 -p com.zhihu.android --pct-anyevent 100 --ignore-crashes --ignore-timeouts --throttle 500 -v 50 > mokeycommandtest.log
***策略阐述：***  

	在设备emulator-5554上启动应用程序（package: com.basecamp.bc3, com.zhihu.android），向其发送50个伪随机事件，  
	其中各事件的比例随机分配；  
	事件间隔时间(throttle)：500 ms  
	打印信息的详细级别:level (-v)  
	忽略任何程序崩溃/失控异常(--ignore-crashes)、超时错误(--ignore-timeouts)  
	将结果输出到当前目录（C:\Users\Michael）的mokeycommandtest.log中。

***详细打印信息：***
[mokeycommandtest.log](http://google.com/ "Google")

##作业4：安装ideviceinstaller，下载一个open souce的xcode project在simulator上运行
*To be finished(Planning to buy a Mac Device)*
