@echo off
cd ..
call mvn clean eclipse:clean eclipse:eclipse -Dwtpversion=2.0 -DincludeScope=runtime  -DdownloadSources=true
cd bin
pause
@echo on