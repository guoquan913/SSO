@echo off
cd ..
call mvn clean package
cd bin
pause
@echo on