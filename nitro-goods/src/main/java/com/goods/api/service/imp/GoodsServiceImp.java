package com.goods.api.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.goods.manage.GetGoodsData;
import com.nitro.entity.GoodsEntity;
import com.nitro.entity.GoodsTypeEntity;
import com.nitro.servicr.GoodsService;
@RestController
public class GoodsServiceImp implements GoodsService {

	@Autowired
    private GetGoodsData getGoodsData;

	@Override
	public List<GoodsTypeEntity> getTopParent() {
		// TODO Auto-generated method stub
		return getGoodsData.getTopParent();
	}


	public List<GoodsEntity> getGoodsEntityRecommend(String parent_id,	Integer start) {
		
		// TODO Auto-generated method stub
		return getGoodsData.getGoodsEntityRecommend(parent_id,start);
	}

}
