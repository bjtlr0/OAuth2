package com.boot.study;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
public class OAuth2ApplicationTests {
	
	@Test
	public void contextLoads() {
	}

}
