# HSQLDB 서버 시작 및 DB 연결 테스트 절차

## 1. HSQLDB 서버 시작 방법

### 1.1. 필수 준비사항
- HSQLDB 라이브러리 (hsqldb-2.3.1.jar) 필요
- Maven 저장소에 라이브러리가 없는 경우, 직접 다운로드 필요

### 1.2. 시작 스크립트
포트 9001을 사용하는 HSQLDB 서버를 시작하기 위해 다음 스크립트를 생성합니다:

```bat
@echo off
setlocal

rem HSQLDB 서버 시작 스크립트 (포트 9001)
set HSQLDB_JAR="C:\Users\ryuso\.m2\repository\org\hsqldb\hsqldb\2.3.1\hsqldb-2.3.1.jar"
set DB_PATH="C:\AITEST\hsqldb-data\broadleaf"
set DB_NAME=broadleaf

echo HSQLDB 서버를 시작합니다...
echo 데이터베이스 경로: %DB_PATH%
echo 데이터베이스 이름: %DB_NAME%

java -cp %HSQLDB_JAR% org.hsqldb.Server --database.0 file:%DB_PATH% --dbname.0 %DB_NAME% --port 9001

pause
```

### 1.3. 실행 방법
1. 위 스크립트를 `start-hsqldb-port9001.bat`로 저장
2. 명령 프롬프트에서 해당 배치 파일 실행
3. HSQLDB 서버가 포트 9001에서 시작됨

## 2. DB 연결 테스트 절차

### 2.1. 테스트용 Java 클래스
`DBConnectionTest.java` 파일은 이미 포트 9001을 사용하도록 구성되어 있음:

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionTest {
    // HSQLDB 연결 정보
    private static final String DB_URL = "jdbc:hsqldb:hsql://localhost:9001/broadleaf";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        Connection connection = null;
        
        try {
            // HSQLDB JDBC 드라이버 로드
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            System.out.println("HSQLDB JDBC 드라이버 로드 성공");
            
            // 데이터베이스 연결
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("데이터베이스 연결 성공: " + DB_URL);
            
        } catch (ClassNotFoundException e) {
            System.err.println("HSQLDB JDBC 드라이버를 찾을 수 없습니다: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("데이터베이스 연결 실패: " + e.getMessage());
        } finally {
            // 연결 종료
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("데이터베이스 연결 종료");
                } catch (SQLException e) {
                    System.err.println("연결 종료 중 오류 발생: " + e.getMessage());
                }
            }
        }
    }
}
```

### 2.2. 컴파일 및 실행
```bash
javac DBConnectionTest.java
java DBConnectionTest
```

## 3. 필요한 설정 파일들

### 3.1. jetty-env.xml
위치: `tomcat-9.0.104/webapps/mycompany/WEB-INF/jetty-env.xml`

주요 설정:
- driverClassName: org.hsqldb.jdbcDriver
- url: jdbc:hsqldb:hsql://localhost/broadleaf
- username: sa
- password: (빈 값)

### 3.2. applicationContext-datasource.xml
위치: `tomcat-9.0.104/webapps/mycompany/WEB-INF/applicationContext-datasource.xml`

JNDI 설정:
- webDS: jdbc/web
- webSecureDS: jdbc/secure
- webStorageDS: jdbc/storage

## 4. 전체 테스트 절차 요약

1. HSQLDB 라이브러리 확인 및 설치
2. 포트 9001을 사용하는 HSQLDB 서버 시작 스크립트 생성 및 실행
3. DBConnectionTest.java를 컴파일하고 실행하여 연결 테스트
4. 연결 성공 여부 확인
5. 테스트 완료 후 서버 종료