package com.nitro.servicr;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nitro.entity.GoodsEntity;
import com.nitro.entity.GoodsTypeEntity;

@RequestMapping("/goods")
public interface GoodsService {
	
	@GetMapping("/getTopParent")
	List<GoodsTypeEntity> getTopParent();
	
	@GetMapping("/getGoodsEntityRecommend")
	List<GoodsEntity> getGoodsEntityRecommend(@RequestParam("parent_id") String parent_id,@RequestParam("start")	Integer start);
	
	

}
