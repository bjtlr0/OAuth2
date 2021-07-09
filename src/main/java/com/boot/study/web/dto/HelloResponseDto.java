/**
 * 
 */
package com.boot.study.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author ksh123
 *
 */

@Getter
@RequiredArgsConstructor
/*
 * RequiredArgsConstructor : 선언된 모든 final필드를 포함한 생성자를 선언해준다.
 * final이 없는 필드는 생성자에 포함되지 않는다.
 * */
public class HelloResponseDto {
	
	private final String name;
	private final int amount;
}
