/**
 * 
 */
package com.boot.study.config.auth.dto;

import java.util.Map;

import com.boot.study.domain.user.Role;
import com.boot.study.domain.user.User;

import lombok.Builder;
import lombok.Getter;

/**
 * @author ksh123
 * OAuth2UserService를 통해 가져온 OAuth2User의 attribute를 담은 클래스
 * naver, kakao, 등등 소셜 로그인에 두루 사용한다. 
 */
@Getter
public class OAuthAttributes {
	private Map<String, Object> attributes;
	private String nameAttributeKey;
	private String name;
	private String email;
	private String picture;
	
	@Builder
	public OAuthAttributes (Map<String, Object> attributes, String nameAttributeKey, String name, String email, String picture){
		this.attributes = attributes;
		this.nameAttributeKey = nameAttributeKey;
		this.name = name;
		this.email = email;
		this.picture = picture;
	}
	
	public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes){ // attributes는 OAuth2User의 Map데이터.
		
		if ("naver".equals(registrationId)){
			return ofNaver("id", attributes);
		}
		
		return ofGoogle(userNameAttributeName, attributes);
	}
	
	public static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes){
		Map<String, Object> response = (Map<String, Object>)attributes.get("response");
		
		return OAuthAttributes.builder()
				.name((String) response.get("name"))
				.email((String) response.get("email"))
				.picture((String) response.get("profile_image"))
				.attributes(response)
				.nameAttributeKey(userNameAttributeName)
				.build();
	}
	
	// OAuth2User의 사용자 정보가 Map형태이기 때문에  OAuthAttributes형태로 변환해준다.
	public static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes){
		return OAuthAttributes.builder()
				.name((String) attributes.get("name"))
				.email((String) attributes.get("email"))
				.picture((String) attributes.get("picture"))
				.attributes(attributes)
				.nameAttributeKey(userNameAttributeName)
				.build();
	}
	
	public User toEntity(){
		return User.builder()
				.name(name)
				.email(email)
				.picture(picture)
				.role(Role.GUEST)
				.build();
	}
}
