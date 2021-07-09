/**
 * 
 */
package com.boot.study.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.study.web.dto.HelloResponseDto;

/**
 * @author ksh123
 *
 */
@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public String hellp(){
		return "hello";
	}
	
	@GetMapping("/hello/dto")
	public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
		return new HelloResponseDto(name, amount);
	}
}
