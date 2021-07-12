# OAuth2

Springboot webservice example

## Maven repository Dependencies list
'spring-boot-starter-security(managed : 2.1.4 RELEASE)
'spring-boot-starter-test(managed : 2.1.4 RELEASE)
spring-boot-starter-data-jpa:2.0.3.RELEASE (managed : 2.1.4 RELEASE)
spring-boot-starter-oauth2-client (managed : 2.1.4 RELEASE)
spring-boot-starter-web (managed : 2.1.4 RELEASE)
spring-boot-starter-mustache (managed : 2.1.4 RELEASE)
spring-session-jdbc (managed : 2.1.5 RELEASE)
spring-security-test (managed : 5.1.5 RELEASE)
mariadb-java-client (managed : 2.3.0)
junit(managed : 4.12)
lombok:1.18.20 (managed : 1.18.6)
h2:1.4.196 (managed : 1.4.199)

# 서버에서 mvnw test 수행 시 test 클래스가 에러 발생하는 이유
test클래스들을 test패키지에 생성하지 않고 본패키지에 포함하였기 때문에 junit등 test에 사용되는 라이브러리들이 로드되지 않았다.
본패키지에서도 test 라이브러리들을 사용할 수 있도록 pom.xml에서 <scope>test</scope> 항목을 주석처리함.(scope태그 공란 시 <scope>compile</scope> 적용)
