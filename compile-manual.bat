@echo off
setlocal

echo [INFO] Setting up Manual Compilation...

REM -----------------------------------------------------------
REM 1. 자바 컴파일러(javac) 위치 설정 (사용자 로그 기반)
REM -----------------------------------------------------------
set "JAVAC_CMD=C:\Program Files\Java\jdk-8\bin\javac.exe"

REM -----------------------------------------------------------
REM 2. 경로 설정
REM -----------------------------------------------------------
set "PROJECT_ROOT=%~dp0"
set "SOURCE_FILE=%PROJECT_ROOT%LegacyDemoSite\site\src\main\java\com\mycompany\controller\cart\VerifyErrorController.java"
set "DEST_DIR=%PROJECT_ROOT%tomcat-9.0.104\webapps\mycompany\WEB-INF\classes"
set "WEB_LIB=%PROJECT_ROOT%tomcat-9.0.104\webapps\mycompany\WEB-INF\lib"
set "TOMCAT_LIB=%PROJECT_ROOT%tomcat-9.0.104\lib"

REM -----------------------------------------------------------
REM 3. 클래스패스 설정 (톰캣 라이브러리 + 웹앱 라이브러리)
REM -----------------------------------------------------------
set "CLASSPATH=%DEST_DIR%;%TOMCAT_LIB%\*;%WEB_LIB%\*"

echo [INFO] Compiling VerifyErrorController.java...
echo Source: %SOURCE_FILE%
echo Dest:   %DEST_DIR%

REM 컴파일 실행
"%JAVAC_CMD%" -cp "%CLASSPATH%" -d "%DEST_DIR%" "%SOURCE_FILE%"

if %ERRORLEVEL% NEQ 0 (
    echo.
    echo [ERROR] Compilation failed!
    echo 소스 코드가 존재하는지, 자바 경로가 맞는지 확인해주세요.
    pause
    exit /b 1
)

echo.
echo [SUCCESS] Compilation Successful!
echo [INFO] The class file has been deployed to Tomcat.
echo [ACTION] Now run 'catalina.bat run' to see the error.
pause