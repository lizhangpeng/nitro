package com.nitro.servicr;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nitro.entity.UserEntity;

@RequestMapping("/member")
public interface UserService {
	/*
	 * 注册服务
	 */
	@PostMapping("/regist")
	public Map<String, Object> regist(@RequestBody UserEntity userEntity);
	/*
	 * 登入注册服务
	 */
	@PostMapping("/login")
	public Map<String, Object>login(@RequestBody UserEntity userEntity);
	
	@GetMapping("/getUser")
	public Map<String, Object> getUser(@RequestParam("token") String token);
	
	
}
