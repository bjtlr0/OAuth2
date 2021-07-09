/**
 * 
 */
package com.boot.study.config.auth;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.boot.study.domain.user.Role;

import lombok.RequiredArgsConstructor;

/**
 * @author ksh123
 *
 */

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	private final CustomOAuth2UserService customOAuth2UserService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.headers().frameOptions().disable() // h2-console화면 사용을 위해 설정
			.and()
				.authorizeRequests()
					.antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
					.antMatchers("/api/v1/**").hasRole(Role.USER.name())
					.anyRequest().authenticated()
			.and()
				.logout()
					.logoutSuccessUrl("/")
			.and()
				.oauth2Login()
					.defaultSuccessUrl("/")
					.userInfoEndpoint() // OAuth2로그인 성공 후 사용자 정보를 가져올 때의 설정들을 담당하는 구문
						.userService(customOAuth2UserService);
	}
}
