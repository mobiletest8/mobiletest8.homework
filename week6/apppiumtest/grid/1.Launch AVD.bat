@echo off
echo Launching android emulator, please wait...
echo Please do not close the window while/after launching.

start cmd /c emulator -port 5676 -avd appium-test-avd-1
start cmd /c emulator -port 5678 -avd appium-test-avd-2
start cmd /c emulator -port 5680 -avd appium-test-avd-3