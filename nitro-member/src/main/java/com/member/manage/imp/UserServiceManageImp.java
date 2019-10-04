package com.member.manage.imp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.utils.MD5Util;
import com.member.common.DBTableName;
import com.member.dao.UserDao;
import com.member.manage.UserServiceManage;
import com.nitro.entity.UserEntity;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceManageImp implements UserServiceManage {

	@Autowired
	private UserDao userDao;
	@Override
	public void regist(Object userEntity) {
		// TODO Auto-generated method stub
		userDao.save(userEntity, DBTableName.TB_MB_USER);
	}
	
	@Override
	public UserEntity login(UserEntity userEntity) {
		String userPassString =MD5Util.MD5(userEntity.getPassword()+userEntity.getMove_number());
		
		String move= userEntity.getMove_number();
		
		return userDao.getUserMoveAndPed(move,userPassString);
	}
	
	public UserEntity getUser(String id) {
		return userDao.getUserMoveAndId(id);
	}

}
