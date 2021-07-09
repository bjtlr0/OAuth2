/**
 * 
 */
package com.boot.study.config.auth.dto;

import java.io.Serializable;

import com.boot.study.domain.user.User;

import lombok.Getter;

/**
 * @author ksh123
 *
 */
@Getter
public class SessionUser implements Serializable{
	private static final long serialVersionUID = -6516580412050898385L;
	private String name;
	private String email;
	private String picture;
	
	public SessionUser(User user){
		this.name = user.getName();
		this.email = user.getEmail();
		this.picture = user.getPicture();
	}
}
