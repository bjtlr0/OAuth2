/**
 * 
 */
package com.boot.study.service.posts;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boot.study.domain.posts.Posts;
import com.boot.study.domain.posts.PostsRepository;
import com.boot.study.web.dto.PostsListResponseDto;
import com.boot.study.web.dto.PostsResponseDto;
import com.boot.study.web.dto.PostsSaveRequestDto;
import com.boot.study.web.dto.PostsUpdateRequestDto;

import lombok.RequiredArgsConstructor;

/**
 * @author ksh123
 *
 */

@RequiredArgsConstructor
@Service
public class PostService {
	private final PostsRepository postsRepository;
	
	@Transactional
	public Long save(PostsSaveRequestDto requestDto){
		return postsRepository.save(requestDto.toEntity()).getId();
	}
	
	@Transactional
	public Long update(Long id, PostsUpdateRequestDto requestDto){
		Posts posts = postsRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
		
		// Posts는 Entity이므로 파라미터 setter를 사용하지 않고 함수를 호출한다.
		posts.update(requestDto.getTitle(), requestDto.getContent());
		return id;
	}
	
	@Transactional
	public void delete(Long id){
		Posts posts = postsRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
		
		postsRepository.delete(posts);
	}
	
	@Transactional(readOnly = true) // readonly 설정에 의해 조회기능만 사용하여 처리속도가 개선된다. 
	public List<PostsListResponseDto> findAllDesc(){
		return postsRepository.findAllDesc().stream()
				.map(PostsListResponseDto::new)
				.collect(Collectors.toList());
	}
	
	// Service객체는 repository를 사용하는 클래스이므로 postsRepository를 직접 부르지 않고
	// 함수화 해서 사용한다
	public PostsResponseDto findById(Long id){
		Posts entity = postsRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
		
		return new PostsResponseDto(entity);
	}
}
