/**
 * 
 */
package com.boot.study.web;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.queryParam;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.boot.study.config.auth.SecurityConfig;

/**
 * @author ksh123
 *
 */

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class, excludeFilters = {
		@ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE, classes=SecurityConfig.class)})
/*
 * WebMvcTest
 * Controller, RestController 사용 가능
 * Service, Component, Repository 등은 사용할 수 없다.
 * 관련 설정된 클래스를 사용하려하면 에러가 발생한다.
 * 
 * */
public class HelloControllerTest {
	@Autowired
	private MockMvc mvc;
	/*
	 *  MockMVC 
	 *  웹 API 테스트, HTTP GET, POST등 API테스트 가능
	 * */
	
	@WithMockUser(roles = "USER")
	@Test
	public void hello가_리턴된다() throws Exception{
		String hello = "hello";
		
		mvc.perform(get("/hello")) // chaining 테스트 가능
			.andExpect(status().isOk()) // status 검증
			.andExpect(content().string(hello)); // contents 검증
	}
	
	@WithMockUser(roles = "USER")
	@Test
	public void helloDto가_리턴된다() throws Exception{
		String name = "hello";
		int amount = 1000;
		
		mvc.perform(
				get("/hello/dto")
					.param("name", name)
					.param("amount", String.valueOf(amount)))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.name", is(name)))
			.andExpect(jsonPath("$.amount", is(amount)));
	}
}
