package com.nitro.servicr;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
public interface MemberApiService {

	@GetMapping(value="/user")
	public Map<String,Object> dome();
}
