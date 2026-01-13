@echo off
setlocal

echo [INFO] Setting up paths...
set "CURRENT_DIR=%~dp0"
rem Source Code Directory (LegacyDemoSite)
set "PROJECT_HOME=%CURRENT_DIR%LegacyDemoSite"
rem Tomcat Webapps Directory
set "TOMCAT_WEBAPPS=%CURRENT_DIR%tomcat-9.0.104\webapps"

echo [INFO] Project Home: %PROJECT_HOME%
echo [INFO] Tomcat Webapps: %TOMCAT_WEBAPPS%

echo.
echo [STEP 1] Compiling 'site' module with Maven...
cd /d "%PROJECT_HOME%"
rem Compiling site module only
call mvn compile -pl site -am

if %ERRORLEVEL% NEQ 0 (
    echo [ERROR] Maven compilation failed!
    pause
    exit /b %ERRORLEVEL%
)

echo.
echo [STEP 2] Deploying classes to 'mycompany' webapp...
rem Copying compiled .class files to Tomcat
xcopy /Y /E /S "%PROJECT_HOME%\site\target\classes\*" "%TOMCAT_WEBAPPS%\mycompany\WEB-INF\classes\"

echo.
echo [SUCCESS] Deployment finished. 
echo [ACTION] Now RESTART Tomcat to trigger SpringLoaded!
pause