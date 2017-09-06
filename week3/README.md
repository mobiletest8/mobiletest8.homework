# mobiletest8.homework.week3
*   [作业1:Charles限速的设置，代理挂上，限速设置好，然后使用app，查看是否限速成功。Android和iOS都要使用，包括从iOS开发者模式下获取限速详细数据](#作业1)
    *   [Android](#android)
    *   [iOS](#ios)
*   [作业2:使用aapt查看Android apk包权限并截图](#作业2)
    *   [aapt dump permissions basecamp3.apk](#aapt)
*   [作业3:使用ApkTool和jar2dex工具来反编译一个apk，打开反编译之后的dex并截图](#作业3)

    
<h2 id="作业1">作业1:Charles限速的设置，代理挂上，限速设置好，然后使用app，查看是否限速成功。Android和iOS都要使用，包括从iOS开发者模式下获取限速详细数据。</h2>  
<h3 id="android">Android</h3>

Throttling is ***disabled***:  
![alt text][img01-02-01]  
Throttling is enabled with ***56 kbps Modem*** as the preset:  
![alt text][img01-02-02]  
Throttling is enabled with ***3G*** as the preset:  
![alt text][img01-02-03]  
Throttling is enabled with ***4G*** as the preset:  
![alt text][img01-02-04]  


<h3 id="ios">iOS</h3>

![alt text][img01-01]    


  [img01-01]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week3/src/common/images/01.png
  [img01-02-01]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week3/src/common/images/01-02-01.png
  [img01-02-02]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week3/src/common/images/01-02-02.png
  [img01-02-03]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week3/src/common/images/01-02-03.png
  [img01-02-04]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week3/src/common/images/01-02-04.png


<h2 id="作业2">作业2:使用aapt查看Android apk包权限并截图。</h2>  

**<h3 id="aapt">aapt dump permissions basecamp3.apk</h3>**

![alt text][img02-01]


  [img02-01]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week3/src/common/images/02-01.png




<h2 id="作业3">作业3. 使用ApkTool和jar2dex工具来反编译一个apk，打开反编译之后的dex并截图。</h2>  

1. Prepare the below tools in place:   
![alt text][img03-01]

2. Navigate to apktool directoy, verify the installation of apktool:  
![alt text][img03-02]

3. Copy ***basecamp3.apk*** to apktool directory, disassemble ***basecamp3.apk***:  
![alt text][img03-03] 

4. Copy ***classes.dex*** to ***dex2jar-2.0*** directory, and convert classes.dex file to ***.class*** files (zipped as ***jar***):  
![alt text][img03-04]

5. Open ***classes-dex2jar.jar*** in ***jd-gui.exe***:  
![alt text][img03-05]


  [img03-01]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week3/src/common/images/03-01.png
  [img03-02]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week3/src/common/images/03-02.png
  [img03-03]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week3/src/common/images/03-03.png
  [img03-04]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week3/src/common/images/03-04.png 
  [img03-05]: https://github.com/mobiletest8/mobiletest8.homework.wanmich/blob/master/week3/src/common/images/03-05.png
