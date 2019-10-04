package com.web.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;

import com.nitro.servicr.GoodsService;

@Service
@FeignClient("goods")
public interface GoodsFeign extends GoodsService {
	
	

}
