package com.web.base.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.common.api.constants.BaseApiConstants;
import com.nitro.entity.GoodsTypeEntity;
import com.nitro.entity.UserEntity;
import com.web.feign.UserFeign;

public class BaseController {
	@Autowired
	private UserFeign userFeign;
	
	public UserEntity getUserEntity(String token) {
		Map<String, Object> usMap =userFeign.getUser(token);
		Integer codeInteger =(Integer) usMap.get(BaseApiConstants.HTTP_CODE);
		if (codeInteger.equals(200)) {
			return null;
		}
		LinkedHashMap<String, Object> linkedHashMap=(LinkedHashMap<String, Object>) usMap.get(BaseApiConstants.HTTP_DATA);
		String jsonString = new JSONObject().toJSONString(linkedHashMap);
		//UserEntity userEntity =(UserEntity) JSONObject.parseObject(jsonString,UserEntity.class);
		return JSONObject.parseObject(jsonString,UserEntity.class);
	}
	
	public Boolean setUserEntity(UserEntity userEntity) {
		Map<String, Object> usMap =userFeign.regist(userEntity);
		Integer codeInteger =(Integer) usMap.get(BaseApiConstants.HTTP_CODE);
		if (codeInteger.equals(200)) {
			return true;
		}
		return false;
	}
	
	public UserEntity loginUser(UserEntity userEntity) {
		Map<String, Object> usMap =userFeign.login(userEntity);
		Integer codeInteger =(Integer) usMap.get(BaseApiConstants.HTTP_CODE);
		if (!codeInteger.equals(200)) {
			return null;
		}
		LinkedHashMap<String, Object> linkedHashMap=(LinkedHashMap<String, Object>) usMap.get(BaseApiConstants.HTTP_DATA);
		String jsonString = new JSONObject().toJSONString(linkedHashMap);
		//UserEntity userEntity =(UserEntity) JSONObject.parseObject(jsonString,UserEntity.class);
		return JSONObject.parseObject(jsonString,UserEntity.class);
	}
	
	

	
	
	

	
	
}
