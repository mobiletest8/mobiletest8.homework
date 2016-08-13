@echo off
echo Launching appium server, do not close this window, please.
appium -a 127.0.0.1 -p 4725 -bp 4726   --selendroid-port 8091 --chromedriver-port 9516 --session-override --nodeconfig E:\Dev\eclipse\workspace\apppiumtest\grid\nodeconfig_2.json