package com.web.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.redis.BaseRedisService;
import com.nitro.entity.UserEntity;
import com.web.base.controller.BaseController;
import com.web.common.TokenTime;

@Controller
@RequestMapping("/member")
public class RegisterController  extends BaseController {
	@Autowired
	private LoginController loginController;
	
	@Autowired
	private BaseRedisService baseRedisService;
	
	@GetMapping("/regist.html")
	public String regist(HttpServletRequest request) {
		
		String token=UUID.randomUUID().toString();
		request.setAttribute("token", token);
		baseRedisService.set(token, token, TokenTime.User_TOKEN_TIME);
		return "register";
	}
	
	

	@PostMapping("/registPost") 
	public String regist(UserEntity userEntity,HttpServletRequest request) { 
		String string = baseRedisService.get(userEntity.getToken());
		if (string==null) {
			return "register";
		}
		if (setUserEntity(userEntity)) {
			return loginController.login(request);
		}else {
			return regist(request);
		}
		
	}

	

}
