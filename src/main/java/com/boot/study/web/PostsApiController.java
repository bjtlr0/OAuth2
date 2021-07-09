/**
 * 
 */
package com.boot.study.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.study.service.posts.PostService;
import com.boot.study.web.dto.PostsResponseDto;
import com.boot.study.web.dto.PostsSaveRequestDto;
import com.boot.study.web.dto.PostsUpdateRequestDto;

import lombok.RequiredArgsConstructor;

/**
 * @author ksh123
 *
 */

@RequiredArgsConstructor
@RestController
public class PostsApiController {
	private final PostService postService;
	
	@PostMapping("/api/v1/posts")
	public Long svae(@RequestBody PostsSaveRequestDto requestDto){
		return postService.save(requestDto);
	}
	
	@PutMapping("/api/v1/posts/{id}")
	public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
		return postService.update(id, requestDto);
	}
	
	@GetMapping("/api/v1/posts/{id}")
	public PostsResponseDto findById(@PathVariable Long id){
		return postService.findById(id);
	}
}
