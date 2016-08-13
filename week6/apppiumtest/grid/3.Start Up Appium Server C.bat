@echo off
echo Launching appium server, do not close this window, please.
appium -a 127.0.0.1 -p 4727 -bp 4728   --selendroid-port 8092 --chromedriver-port 9517 --session-override --nodeconfig E:\Dev\eclipse\workspace\apppiumtest\grid\nodeconfig_3.json