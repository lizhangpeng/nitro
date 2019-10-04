package com.member.token;

import java.util.UUID;
import org.springframework.stereotype.Service;
@Service
public class TokenUtis {
	
	public String getToken() {
		return UUID.randomUUID().toString();
	}

}
