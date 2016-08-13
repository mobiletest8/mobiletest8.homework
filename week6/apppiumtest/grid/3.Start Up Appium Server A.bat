@echo off
echo Launching appium server, do not close this window, please.
appium -a 127.0.0.1 -p 4723 -bp 4724 --selendroid-port 8090 --chromedriver-port 9515 --session-override --nodeconfig E:\Dev\eclipse\workspace\apppiumtest\grid\nodeconfig_1.json