@echo off
setlocal

rem DBConnectionTest.java 컴파일 및 실행 스크립트
set HSQLDB_JAR=lib/hsqldb-2.3.1.jar

echo DBConnectionTest.java를 컴파일합니다...
javac -cp %HSQLDB_JAR% DBConnectionTest.java
if %ERRORLEVEL% neq 0 (
    echo 컴파일 실패
    pause
    exit /b %ERRORLEVEL%
)

echo DBConnectionTest를 실행합니다...
java -cp ".;%HSQLDB_JAR%" DBConnectionTest
pause