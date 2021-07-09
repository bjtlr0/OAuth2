/**
 * 
 */
package com.boot.study.config.auth;

import javax.servlet.http.HttpSession;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.boot.study.config.auth.dto.SessionUser;

import lombok.RequiredArgsConstructor;

/**
 * @author ksh123
 * LoginUser 오브젝트를 맵핑시켜 줄 리졸버 클래스.
 * 
 * view로부터 전달된 파라미터를 체크해서 메서드 조건에 맞는 경우,
 * handlerMethodArgumentResolver의 구현체에 의해 지정된 값으로
 * 변환하여 넘긴다.
 */

@RequiredArgsConstructor
@Component
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver{

	private final HttpSession httpSession;
	
	// 특정 파라미터 조건이 맞다면 주어진 객체를 생성해서 전달.
	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, 
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		return httpSession.getAttribute("user");
	}

	// 컨트롤러 메서드의 특정 파라미터를 지원하는지 확인
	// @LoginUser어노테이션이고 SessionUser.class인지 확인.
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		boolean isLoginUserAnnotation = parameter.getParameterAnnotation(LoginUser.class) != null;
		boolean isUserClass = SessionUser.class.equals(parameter.getParameterType());
		
		return isLoginUserAnnotation && isUserClass;
	}

}
