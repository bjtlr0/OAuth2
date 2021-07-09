/**
 * 
 */
package com.boot.study.domain.posts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.boot.study.domain.BaseTimeEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author ksh123
 *
 */

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity{
	/*
	 * Entity : db테이블로 링크될 클래스임을 나타낸다.
	 * Column 어노테이션을 선언하지 않아도 entity클래스의 필드는 모두 column으로 선언된다.
	 *  별도의 필요한 컬럼옵션이 있는 경우 column어노테이션을 통해 선언한다.
	 *  
	 * Entity 클래스에서는 절대 setter를 만들지 않는다고 한다
	 * getter/setter를 무작정 생성하는 경우 클래스의 인스턴스 값들이 언제 변경되는지 알 수가 없다고 ..
	 * */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)// springboot2.0에서는 IDENTITY를 줘야 auto_increment가 적용됨.
	private Long id;
	
	@Column(length = 500, nullable = false)
	private String title;
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;
	
	private String author;
	
	@Builder
	public Posts (String title, String content, String author){
		this.title = title;
		this.content = content;
		this.author = author;
	}
	
	// !! jpa에 의해 entity는 영속성컨텍스트가 된다.
	// transaction안에서 해당 함수가 수행되는 경우, 
	// 별도로 query를 수행하지 않아도 database에 값이 영구저장된다.
	// 이러한 개념을 더티체킹(dirty checking)이라고 한다.
	public void update(String title, String content){
		this.title = title;
		this.content = content;
	}
}
