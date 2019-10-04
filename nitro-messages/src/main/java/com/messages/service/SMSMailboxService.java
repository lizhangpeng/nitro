package com.messages.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.messages.adapter.MessagesAdapter;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class SMSMailboxService implements MessagesAdapter {

	@Autowired
	private JavaMailSender mailSender; // 自动注入的Bean
	private String mail;
	@Override
	public void distribute(JSONObject jsonObject) {
		
		System.out.println(jsonObject.toString());
		// TODO Auto-generated method stub
		String mailString = jsonObject.getString("mail");
		String move_number = jsonObject.getString("move_number");
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("lizhangpengjava@163.com");
		message.setTo(mailString); // 自己给自己发送邮件
		message.setSubject("蚂蚁课堂第一期结业项目微信商城会员注册成功");
		message.setText("恭喜您"+move_number+",成为微信商城的新用户!谢谢您的光临!www.itmayiedu.com");
		log.info("###发送短信邮箱 mail:{}", mailString);
		mailSender.send(message);
		
	}

}
