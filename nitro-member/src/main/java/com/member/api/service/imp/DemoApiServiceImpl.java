
package com.member.api.service.imp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.common.api.BaseApiService;
import com.common.redis.BaseRedisService;
import com.nitro.servicr.DemoApiService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class DemoApiServiceImpl extends BaseApiService implements DemoApiService {

	@Autowired
	private BaseRedisService baseRedisService;
	@Override
	public Map<String, Object> demo() {

		Map<String, Object> map= new HashMap<String, Object>();
		map.put("111", 2000);
		return map;
	}

	@Override
	public Map<String, Object> setKey(String key,String value) {
		// TODO Auto-generated method stub
		baseRedisService.setString(key, value);
		return null;
	}

	@Override
	public Map<String, Object> getKey(String key) {
		// TODO Auto-generated method stub
		Object object=baseRedisService.get(key);
		
		return setResutr(200, "succer", object);
	}



}
