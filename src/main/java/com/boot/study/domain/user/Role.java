/**
 * 
 */
package com.boot.study.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author ksh123
 *
 */
@Getter
@RequiredArgsConstructor
public enum Role {
	GUEST("ROLE_GUEST", "손님"),
	USER("ROLE_USER", "사용자");
	
	private final String key;
	private final String title;
}
