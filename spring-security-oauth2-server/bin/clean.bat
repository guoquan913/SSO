@echo off
cd ..
call mvn clean eclipse:clean
cd bin
pause
@echo on