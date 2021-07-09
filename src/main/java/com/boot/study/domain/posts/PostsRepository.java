/**
 * 
 */
package com.boot.study.domain.posts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author ksh123
 *
 */
public interface PostsRepository extends JpaRepository<Posts, Long>{
	@Query("SELECT p From Posts p ORDER BY p.id DESC")
	List<Posts> findAllDesc();
}
