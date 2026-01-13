@echo off
setlocal

rem 전체 HSQLDB 테스트 절차 실행 스크립트

echo HSQLDB 데이터 디렉토리를 생성합니다...
if not exist hsqldb-data mkdir hsqldb-data
if not exist hsqldb-data\broadleaf mkdir hsqldb-data\broadleaf

echo HSQLDB 서버를 백그라운드에서 시작합니다...
start "" start-hsqldb-port9001.bat

echo 잠시 대기합니다... (서버 시작 대기)
timeout /t 10 /nobreak >nul

echo DBConnectionTest.java를 컴파일하고 실행합니다...
call run-db-connection-test.bat

echo 테스트가 완료되었습니다.
pause