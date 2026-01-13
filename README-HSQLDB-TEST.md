# HSQLDB 서버 시작 및 DB 연결 테스트

이 디렉토리에는 HSQLDB 서버를 시작하고 DB 연결을 테스트하기 위한 스크립트들이 포함되어 있습니다.

## 파일 구성

1. `lib/hsqldb-2.3.1.jar` - HSQLDB JDBC 드라이버 라이브러리
2. `start-hsqldb-port9001.bat` - HSQLDB 서버를 포트 9001에서 시작하는 스크립트
3. `run-db-connection-test.bat` - DBConnectionTest.java를 컴파일하고 실행하는 스크립트
4. `run-full-hsqldb-test.bat` - 전체 테스트 절차를 자동으로 실행하는 스크립트
5. `DBConnectionTest.java` - DB 연결 테스트를 위한 Java 프로그램

## 사용 방법

### 방법 1: 전체 테스트 자동 실행 (권장)
```
run-full-hsqldb-test.bat
```

이 스크립트는 다음 작업을 순차적으로 자동으로 수행합니다:
1. HSQLDB 데이터 디렉토리 생성
2. HSQLDB 서버를 백그라운드에서 시작
3. DBConnectionTest.java 컴파일
4. DB 연결 테스트 실행

### 방법 2: 개별 스크립트 실행
1. HSQLDB 서버 시작:
   ```
   start-hsqldb-port9001.bat
   ```

2. 새 명령 프롬프트 창에서 DB 연결 테스트:
   ```
   run-db-connection-test.bat
   ```

## 테스트 결과 해석

- "데이터베이스 연결 성공" 메시지가 출력되면 테스트 성공
- "데이터베이스 연결 실패" 메시지가 출력되면 테스트 실패

## 문제 해결

1. **"javac" 명령어를 찾을 수 없다는 오류 발생 시**
   - JDK가 시스템에 설치되어 있고 PATH 환경 변수에 추가되었는지 확인하세요.

2. **"HSQLDB JDBC 드라이버를 찾을 수 없습니다" 오류 발생 시**
   - lib/hsqldb-2.3.1.jar 파일이 존재하는지 확인하세요.

3. **"데이터베이스 연결 실패" 오류 발생 시**
   - HSQLDB 서버가 정상적으로 시작되었는지 확인하세요.
   - 포트 9001이 다른 프로세스에 의해 사용되고 있는지 확인하세요.