package com.messages.mq.distribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSONObject;
import com.member.common.MQInterfaceType;
import com.messages.adapter.MessagesAdapter;
import com.messages.service.SMSMailboxService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Component
public class ConsumerDistribute {
	@Autowired
	private SMSMailboxService  sMSMailboxService;
	
	@JmsListener(destination = "messages_queue")
	public void distribute(String json) {
		log.info("---消息服务-----消息内容：{}",json);
		 getType(json);
	}
	
	public void getType(String json) {
		MessagesAdapter messagesAdapter  =null;
		JSONObject jsonObject =new JSONObject().parseObject(json);
		JSONObject header = jsonObject.getJSONObject("header");
		String typeString  = header.getString("interfaceType");
		switch (typeString) {
			case MQInterfaceType.SMS_MSIL:
				messagesAdapter=sMSMailboxService;
				break;

			default:
				break;
		}
		messagesAdapter.distribute(jsonObject.getJSONObject("content"));
		
		
	}

}
