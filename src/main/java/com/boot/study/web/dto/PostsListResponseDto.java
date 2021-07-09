/**
 * 
 */
package com.boot.study.web.dto;

import java.time.LocalDateTime;

import com.boot.study.domain.posts.Posts;

import lombok.Getter;

/**
 * @author ksh123
 *
 */
@Getter
public class PostsListResponseDto {
	private Long id;
	private String title;
	private String author;
	private LocalDateTime modifiedDate;
	
	public PostsListResponseDto(Posts entity){
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.author = entity.getAuthor();
		this.modifiedDate = entity.getModifiedDate();
	}
}
