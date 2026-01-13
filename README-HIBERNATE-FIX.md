# Hibernate 설정 문제 해결 방법

## 문제 원인
Hibernate의 `hbm2ddl.auto` 설정이 `create-drop` 또는 `update`로 되어 있어서 테이블을 삭제하려고 시도하지만 테이블이 존재하지 않아 오류가 발생하고 있습니다.

## 해결 방법

### 1. hibernate-fix.properties 파일 사용
`hibernate-fix.properties` 파일에는 다음과 같은 설정이 포함되어 있습니다:

```properties
# hbm2ddl.auto 속성을 validate로 변경하여 테이블이 없을 경우 생성되도록 설정
blPU.hibernate.hbm2ddl.auto=validate
blCMSStorage.hibernate.hbm2ddl.auto=validate
blSecurePU.hibernate.hbm2ddl.auto=validate
```

### 2. 적용 방법
1. 이 파일을 프로젝트의 classpath에 추가합니다.
2. 또는 시스템 속성으로 지정합니다: `-Dproperty-override=/path/to/hibernate-fix.properties`

### 3. 대안 설정
만약 자동 생성/삭제를 원하지 않는다면 아래와 같이 설정할 수 있습니다:

```properties
# 자동 생성/삭제를 비활성화
blPU.hibernate.hbm2ddl.auto=none
blCMSStorage.hibernate.hbm2ddl.auto=none
blSecurePU.hibernate.hbm2ddl.auto=none
```

## hbm2ddl.auto 옵션 설명
- `create`: 데이터베이스 스키마를 새로 생성
- `create-drop`: create와 동일하지만 SessionFactory 종료 시 스키마 삭제
- `update`: 기존 스키마를 변경 (추가된 필드 등 반영)
- `validate`: 스키마를 검증만 수행
- `none`: 아무런 작업도 수행하지 않음

## 추가 조치
1. `InitializeDatabase.java`를 실행하여 필요한 테이블을 미리 생성할 수 있습니다.
2. 또는 데이터베이스 초기화 스크립트를 직접 실행할 수 있습니다.