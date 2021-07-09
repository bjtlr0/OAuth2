/**
 * 
 */
package com.boot.study.domain.posts;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ksh123
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
	@Autowired
	PostsRepository postsRepository;
	
	@After
	public void cleanup(){
		postsRepository.deleteAll();
	}
	
	@Test
	public void 게시글저장_불러오기(){
		String title = "테스트 게시글";
		String content = "테스트 본문";
		
		postsRepository.save(Posts.builder() // saveposts에 insert/update쿼리 실행, id값이 있다면 update, 없다면 insert
					.title(title)
					.content(content)
					.author("bjtlr0@gmail.com")
					.build()
				);
		
		List<Posts> postsList = postsRepository.findAll();
		
		Posts posts = postsList.get(0);
		assertThat(posts.getTitle()).isEqualTo(title);
		assertThat(posts.getContent()).isEqualTo(content);
	}
	
	@Test
	public void BaseTimeEntity_등록(){
		LocalDateTime now = LocalDateTime.of(2020,07,05,0,0,0);
		postsRepository.save(Posts.builder()
					.title("title")
					.content("content")
					.author("author")
					.build()
				);
		
		List<Posts> postsList = postsRepository.findAll();
		
		Posts posts = postsList.get(0);
		
		System.out.println(">>>>>>>>>>>>>>>>> createDate = " + posts.getCreateDate() + ", modifiedDate = " + posts.getModifiedDate());
		
		assertThat(posts.getCreateDate()).isAfter(now);
		assertThat(posts.getModifiedDate()).isAfter(now);
	}
}
