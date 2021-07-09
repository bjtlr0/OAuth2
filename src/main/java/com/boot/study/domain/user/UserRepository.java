/**
 * 
 */
package com.boot.study.domain.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ksh123
 *
 */
public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByEmail(String email);
}
