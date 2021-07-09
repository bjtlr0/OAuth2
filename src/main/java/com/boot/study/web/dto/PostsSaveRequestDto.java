/**
 * 
 */
package com.boot.study.web.dto;

import com.boot.study.domain.posts.Posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author ksh123
 *
 */
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
	/*
	 * Entity 클래스와 비슷한 구조이나 DTO클래스로 생성한 이유
	 * Entity클래스는 데이터베이스와 직결된 클래스이므로 Request/Response클래스로 사용하면 안된다.
	 * */
	private String title;
	private String content;
	private String author;
	
	@Builder
	public PostsSaveRequestDto(String title, String content, String author){
		this.title = title;
		this.content = content;
		this.author = author;
	}
	
	public Posts toEntity() {
		return Posts.builder()
				.title(title)
				.content(content)
				.author(author)
				.build();
	}
}
