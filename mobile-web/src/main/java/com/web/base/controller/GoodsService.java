package com.web.base.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import com.nitro.entity.GoodsEntity;
import com.nitro.entity.GoodsTypeEntity;
import com.web.feign.GoodsFeign;


public class GoodsService {

	@Autowired
	private GoodsFeign goodsFeign;

	public List<GoodsTypeEntity> getTopParent(){
		
		return goodsFeign.getTopParent();
	}
	
	public List<GoodsEntity> getGoodsEntityRecommend( String parent_id,Integer start){
		return goodsFeign.getGoodsEntityRecommend(parent_id, start);
	}
	
	
	
}
