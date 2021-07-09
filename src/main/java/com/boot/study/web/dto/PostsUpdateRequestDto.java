/**
 * 
 */
package com.boot.study.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author ksh123
 *
 */

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
	private String title;
	private String content;
	
	@Builder
	public PostsUpdateRequestDto(String title, String content){
		this.title = title;
		this.content = content;
	}
}
