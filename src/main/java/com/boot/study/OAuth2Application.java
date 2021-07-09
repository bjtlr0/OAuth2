package com.boot.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableJpaAuditing // AuditingEntityListener.class등 JPA Auditing기능의 사용을 위해 명시적으로 활성화
// test를 위해 enableJpaAuditing을 제거.
@SpringBootApplication
public class OAuth2Application {

	public static void main(String[] args) {
		SpringApplication.run(OAuth2Application.class, args);
	}

}
