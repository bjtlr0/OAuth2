/**
 * 
 */
package com.boot.study.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.boot.study.config.auth.LoginUser;
import com.boot.study.config.auth.dto.SessionUser;
import com.boot.study.service.posts.PostService;
import com.boot.study.web.dto.PostsResponseDto;

import lombok.RequiredArgsConstructor;

/**
 * @author ksh123
 * RequiredArgsConstructor가 생성자가 필요한 객체에 대해 자동으로 Create를 해준다.
 */
@RequiredArgsConstructor
@Controller
public class IndexController {
	private final PostService postService;
//	private final HttpSession httpSession;
	
	@GetMapping("/")
//	public String index(Model model){
	public String index(Model model, @LoginUser SessionUser user){
		model.addAttribute("posts", postService.findAllDesc());
		
		// CustomOAuth2UserService에 의해 oauth2로그인이 성공했다면 SessionUser의 값이 저장되어 있다.
		/*SessionUser user = (SessionUser) httpSession.getAttribute("user");
		if (user != null){
			model.addAttribute("userName", user.getName());
		}*/
		// HttpSession객체가 LoginUserArgumentResolver에 의해 @LoginUser SessionUser로 변환되어 리턴되므로
		// 불필요한 생성자가 필요없이 바로 사용이 가능하다.
		if (user != null){
			model.addAttribute("userName", user.getName());
		}
		
		
		return "index";
	}
	
	@GetMapping("/posts/update/{id}")
	public String postsUpdate(@PathVariable Long id, Model model){
		PostsResponseDto dto = postService.findById(id);
		model.addAttribute("post", dto);
		
		return "posts-update";
	}
	
	@GetMapping("/posts/save")
	public String postsSave(){
		return "posts-save";
	}
}
