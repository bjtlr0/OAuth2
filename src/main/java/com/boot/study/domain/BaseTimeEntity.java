/**
 * 
 */
package com.boot.study.domain;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

/**
 * @author ksh123
 * MappedSuperclass : JPA Entity클래스들이 baseTimeEntity를 상속할 경우 Date필드들도 Column으로 인식합니다.
 * EntityListeners(AuditingEntityListener) : BaseTimeEntity에 auditing기능을 포함시킵니다.
 * 
 * 해당 기능의 사용을 위해 Application class에 EnableJpaAuditing 어노테이션을 명시한다. 
 */

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {
	@CreatedDate // entity가 생성될 때 자동으로 시간이 저장되는 컬럼
	private LocalDateTime createDate;
	
	@LastModifiedDate // entity가 업데이트 될때 자동으로 시간이 업데이트 되는 컬럼
	private LocalDateTime modifiedDate;
}
