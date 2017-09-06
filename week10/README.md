# mobliletest8.homework.week10
*   [作业1：Android gfxinfo的使用（任挑一个应用Demo）](#hw1)
*   [作业2：TraceView的使用（点、跟踪方法）](#hw2)
*   [作业3：Systrace的使用（官方文档阅读、Python systrace.py）](#hw3)
*   [作业4：Instruments中的time profiler和core animation的使用](#hw4)


<h2 id="hw1">作业1：Android gfxinfo的使用（任挑一个应用Demo）</h2>

1. In the Developer options, turn on the tool by checking in **adb shell dumpsys gfxinfo** of the **Profile GPU rendering** option:  
![alt text][img1-1]  
2. After launching the application and scrolling the main timeline, run the following command from a terminal:  
![alt text][img1-2]  
3. In the resulting [log file], find the section entitled **Profile data in ms**. This section contains a table of 3 columns. To use this data, simply copy the table and paste it to Excel spreadsheet and generate a stacked columns chart. The chart below is the result of my measurement:  
![alt text][img1-3]  
Each column gives an estimate of how long each frame takes to render:  

*    **Draw** is the time spent building display lists in Java. It indicates how much time is spent running methods.
*    **Process** is the time spent by Android’s 2D renderer to execute the display lists. The more Views in your hierarchy, the more drawing commands must be executed.  
*    **Execute** is the time it took to send a frame to the compositor. This part of the graph is usually small. 

_**Reminder:** to render smoothly at 60 fps, each frame must take less than 16 ms to complete._


<h2 id="hw2">作业2：TraceView的使用（点、跟踪方法）</h2>

1. Open **DDMS** and click **Start Method Profiling**:  
![alt text][img2-1]  
2. Do some operations that take time to respond, like scrool List View, switch Tab, etc.  
3. Click **Stop Method Profiling**, DDMS will stop profiling and opens Traceview with the method profiling information.  
4. Filter the targeted app by typing app name in the **Find** inputbox, sort by **Incl Real Time**:  
![alt text][img2-2]  
5. Click the method and child method that take the most time, level by level to check the details and the probable cause.

<h2 id="hw3">作业3：Systrace的使用（官方文档阅读、Python systrace.py）</h2>

To use **systrace**, open a terminal and from the directory ***platform-tools\systrace*** in the Android SDK, run the following command:  
![alt text][img3-1]  
In my case, the following type of events are profiled:  
gfx: **Graphics**  
view: **View**  
wm: **Window Manager**  
While capturing, do some operations that take time to respond, like scrool List View, switch Tab, etc.  
10 s later, the resulting trace will be generated, it is a stand-alone HTML document, open it in Chrome:  
![alt text][img3-2]  
_**Tip:** to navigate a systrace document, use the WASD keys to pan and zoom. W will zoom in on the mouse cursor._  
**Inspecting Frames & Alerts**  
Ideally, rendering frames will be within the 16 ms threshold (green circle), but some will take more time (yellow and red circle).  
Zoom in using the 'W' key to find out more details about the frames:  
![alt text][img3-3]   

<h2 id="hw4">作业4：Instruments中的time profiler和core animation的使用</h2>

_N/A_


[log file]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week10/src/common/files/fps.txt
[img1-1]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week10/src/common/images/1-1.png
[img1-2]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week10/src/common/images/1-2.png
[img1-3]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week10/src/common/images/1-3.png
[img2-1]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week10/src/common/images/2-1.png
[img2-2]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week10/src/common/images/2-2.png
[img3-1]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week10/src/common/images/3-1.png
[img3-2]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week10/src/common/images/3-2.png
[img3-3]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week10/src/common/images/3-3.png
