# 프로젝트 요약

## 프로젝트 개요
이 프로젝트는 Broadleaf Commerce E-commerce 플랫폼을 기반으로 한 쇼핑몰 시스템입니다. HSQLDB를 사용하는 개발 환경으로 구성되어 있으며, Tomcat 서버에서 실행됩니다.

## 주요 구성 요소

### 1. 데이터베이스 구성
- **데이터베이스 엔진**: HSQLDB (버전 2.3.1)
- **접속 정보**: 
  - URL: jdbc:hsqldb:hsql://localhost:9001/broadleaf
  - 사용자: sa (비밀번호 없음)
- **데이터베이스 파일 위치**: C:\AITEST\hsqldb-data\broadleaf

### 2. 서버 구성
- **애플리케이션 서버**: Apache Tomcat 9.0.104
- **포트**: 8080 (HTTP)
- **관리 포트**: 8006 (shutdown)

### 3. 주요 모듈
- **Broadleaf Commerce Core**: E-commerce 플랫폼 핵심 모듈
- **mycompany 웹 애플리케이션**: 실제 쇼핑몰 사이트
- **Admin 모듈**: 관리자 인터페이스

## 실행 구조

### 1. 데이터베이스 시작
1. `start-hsqldb.bat` 파일 실행
2. HSQLDB 서버가 9001 포트에서 시작됨
3. `InitializeDatabase.java`를 실행하여 초기 테이블 생성 및 샘플 데이터 입력

### 2. 애플리케이션 서버 시작
1. Tomcat 서버 시작 (startup.bat)
2. 다음의 데이터 소스를 사용하여 데이터베이스 연결:
   - jdbc/web
   - jdbc/storage  
   - jdbc/secure
3. mycompany 웹 애플리케이션 배포

### 3. 접근 경로
- **쇼핑몰 사이트**: http://localhost:8080/mycompany
- **관리자 페이지**: http://localhost:8080/admin
- **Tomcat 관리자**: http://localhost:8080/manager (사용자: admin / 비밀번호: admin)

## 주요 특징
1. **Hibernate 설정**: 테이블 자동 생성/삭제를 방지하기 위해 `hbm2ddl.auto=validate`로 설정
2. **멀티 데이터소스**: Web, Storage, Secure 세 가지 데이터소스를 별도로 구성
3. **개발 환경 최적화**: 로컬 HSQLDB를 사용하여 별도의 데이터베이스 설치 없이 개발 가능