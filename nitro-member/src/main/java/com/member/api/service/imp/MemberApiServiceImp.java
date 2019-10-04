package com.member.api.service.imp;

import java.util.Map;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.common.api.BaseApiService;
import com.common.redis.BaseRedisService;
import com.common.utils.DateUtils;
import com.common.utils.MD5Util;
import com.member.common.MQInterfaceType;
import com.member.common.TokenTime;
import com.member.manage.imp.UserServiceManageImp;
import com.member.mq.rodcer.RegisterMailboxProducer;
import com.member.token.TokenUtis;
import com.nitro.entity.UserEntity;
import com.nitro.servicr.UserService;


@RestController
public class MemberApiServiceImp extends BaseApiService implements UserService {

	@Autowired
	private UserServiceManageImp userServiceManageImp;
	@Autowired
	private RegisterMailboxProducer registerMailboxProducer;
	@Autowired
	private TokenUtis tokenUtis;
	@Autowired
	private BaseRedisService baseRedisService;
	
	@Value("${messages.queue}")
	private String MY_Messaging_QUEUE;
	
	
	@Override
	public Map<String, Object> regist(@RequestBody UserEntity userEntity) {
		String paString=userEntity.getPassword();
		userEntity.setPassword(MD5Util.MD5(paString+userEntity.getMove_number()));
		userEntity.setRegister_DataTime(DateUtils.getTimestamp());
		userEntity.setLand_DataTime(DateUtils.getTimestamp());
		userServiceManageImp.regist(userEntity);
		registerMailboxProducer.send(new ActiveMQQueue(MY_Messaging_QUEUE),mailMessaging(userEntity));
		return BaseApiService.setResutSuccser();
	}
	
	public String mailMessaging(UserEntity userEntity) {
		JSONObject root= new JSONObject();
		JSONObject header= new JSONObject();
		JSONObject content= new JSONObject();
		header.put("interfaceType", MQInterfaceType.SMS_MSIL);
		content.put("mail", userEntity.getMailbox());
		content.put("move_number", userEntity.getMove_number());
		root.put("header", header);
		root.put("content", content);
		return root.toString();
	}

	@Override
	public Map<String, Object> login(@RequestBody UserEntity userEntity) {
		UserEntity entity;
		if (userEntity.getToken()==null||userEntity.getToken().equals("")) {
			entity=userServiceManageImp.login(userEntity);
			if (entity!=null) {
				entity.setToken(tokenUtis.getToken());
				baseRedisService.set(entity.getToken(), entity.getId().toString(),TokenTime.User_TOKEN_TIME);
			}

		}else {
			entity=userServiceManageImp.getUser(userEntity.getToken().toString());
		}
		
		if (entity==null) {
			return setResutr(204,"账号密码错误","");
		}
		return setResutSuccserData(entity);

	}
	
	public Map<String, Object> getUser(@RequestParam("token") String token) {
		UserEntity entityUser = null;
		String idString=baseRedisService.get(token);
		if (idString!=null&&!idString.equals("")) {
			entityUser=userServiceManageImp.getUser(idString);
		}
		return setResutSuccserData(entityUser);
	}
	



}
