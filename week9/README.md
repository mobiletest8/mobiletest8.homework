#mobliletest8.homework.week9
*   [作业1：阅读Monkey源码，尤其是操作方面的内容](#hw1)
*   [作业2：尝试在Mac下使用CrashMonkey4iOS](#hw2)
*   [作业3：使用Android Studio, hprof, MAT分析内存泄漏](#hw3)
*   [作业4：JSPatch和RN，两者选一，跑demo](#hw4)

<h2 id="hw1">作业1：阅读Monkey源码，尤其是操作方面的内容</h2>
_N/A_
<h2 id="hw2">作业2：尝试在Mac下使用CrashMonkey4iOS</h2>
_(To be finished)_
<h2 id="hw3">作业3：使用Android Studio, hprof, MAT分析内存泄漏</h2>
Here, the sample project is **[HoneycombGallery]**.

In ***Android Studio***, do the below change:
In **[ContentFragment.java]**, add a new static variable:
```java
private static HashMap<String,Bitmap> sBitmapCache = new HashMap<String,Bitmap>();
```
change the ***updateContentAndRecycleBitmap()*** method to check the cache before loading:
```java
void updateContentAndRecycleBitmap(int category, int position) {
    if (mCurrentActionMode != null) {
        mCurrentActionMode.finish();
    }
 
    // Get the bitmap that needs to be drawn and update the ImageView.
 
    // Check if the Bitmap is already in the cache
    String bitmapId = "" + category + "." + position;
    mBitmap = sBitmapCache.get(bitmapId);
 
    if (mBitmap == null) {
        // It's not in the cache, so load the Bitmap and add it to the cache.
        // DANGER! We add items to this cache without ever removing any.
        mBitmap = Directory.getCategory(category).getEntry(position)
                .getBitmap(getResources());
        sBitmapCache.put(bitmapId, mBitmap);
    }
    ((ImageView) getView().findViewById(R.id.image)).setImageBitmap(mBitmap);
}
```
Now, launch the **[HoneycombGallery]**, try to open different Balloons:  
![alt text][img3-01]  
In Android Studio, ***memory monitor*** shows that memory increases dramatically:
then, manually ***cause GC*** for a few times: 
![alt text][img3-02]  
Click the ***Dump HPROF file*** button, to get the hprof file, then convert the ***.hprof file*** from the Dalvik format to the J2SE HPROF format by the below command:  
    hprof-conv com.example.android.hcgallery_2016.09.10_21.21.hprof converted-dump.hprof  
    
Open converted-dump.hprof in ***eclipse MAT***:  
![alt text][img3-03]  
Click **Histogram**, the below view will be shown, sort by **Retained Heap**:  
![alt text][img3-04]  
Select **with incoming references**:  
![alt text][img3-05]  
For the first item, select **exclude week/soft references**:  
![alt text][img3-06]  
**Open Dominator Tree for entire heap**:  
![alt text][img3-07]  
It is obvious that ***ContentFragment*** occupies most of the heap.

<h2 id="hw4">作业4：JSPatch和RN，两者选一，跑demo</h2>
By following instructions here:
http://facebook.github.io/react-native/docs/getting-started.html

Install **node.js** and **Python2**, then **React Native** in command line interface by the below command:  
    npm install -g react-native-cli

After that, create **a new React Native project** called "AwesomeProject":  
    react-native init AwesomeProject

then run the below command in the newly created folder to run the project:  
    cd AwesomeProject
    react-native run-android
    
![alt text][img4-01] 

When it’s built successfully, in emulator the below are shown:  
![alt text][img4-02]  
Update the **index.android.js** in the project’s folder:  
![alt text][img4-03]  
In emulator, the change will be shown by pressing the **R** key twice or selecting **Reload** from the Developer Menu:  
![alt text][img4-04]  
***Note: If the packager is not started automatically when running react-native run-android. Start it manually by using react-native start.***  
![alt text][img4-05] 



[HoneycombGallery]: https://github.com/Miserlou/Android-SDK-Samples/tree/master/HoneycombGallery
[ContentFragment.java]: https://github.com/Miserlou/Android-SDK-Samples/blob/master/HoneycombGallery/src/com/example/android/hcgallery/ContentFragment.java
[img3-01]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week9/src/common/images/3-01.png
[img3-02]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week9/src/common/images/3-02.png
[img3-03]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week9/src/common/images/3-03.png
[img3-04]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week9/src/common/images/3-04.png
[img3-05]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week9/src/common/images/3-05.png
[img3-06]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week9/src/common/images/3-06.png
[img3-07]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week9/src/common/images/3-07.png
[img4-01]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week9/src/common/images/4-01.png
[img4-02]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week9/src/common/images/4-02.png
[img4-03]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week9/src/common/images/4-03.png
[img4-04]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week9/src/common/images/4-04.png
[img4-05]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week9/src/common/images/4-05.png
[img4-06]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week9/src/common/images/4-06.png