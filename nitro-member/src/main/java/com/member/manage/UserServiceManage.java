package com.member.manage;

import org.springframework.web.bind.annotation.RequestBody;

import com.nitro.entity.UserEntity;

public interface UserServiceManage {
	
	public void regist(Object userEntity);
	
	public UserEntity login( UserEntity userEntity);

}
