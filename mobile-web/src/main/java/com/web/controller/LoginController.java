package com.web.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nitro.entity.UserEntity;
import com.web.base.controller.BaseController;
import com.web.common.TokenTime;

@Controller
@RequestMapping("/member")
public class LoginController  extends BaseController{
	
	
	@GetMapping("/login.html")
	public String login(HttpServletRequest request) {
		return "login";
	}
	
	
	@PostMapping("/loginPost") 
	public String login(String username,String pwd,HttpServletRequest request) { 
		UserEntity userEntity =new UserEntity();
		userEntity.setMove_number(username);
		userEntity.setPassword(pwd);
		UserEntity entity=loginUser(userEntity);
		if (entity==null) {
			request.setAttribute("userError", "账号或密码错误");
			return "login";
		}else {
			request.setAttribute("user", entity);
		}
		return "index";
	}

	

}
