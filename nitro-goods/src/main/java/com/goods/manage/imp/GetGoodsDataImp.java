package com.goods.manage.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goods.dao.GoodsDao;
import com.goods.manage.GetGoodsData;
import com.nitro.entity.GoodsEntity;
import com.nitro.entity.GoodsTypeEntity;
@Service
public class GetGoodsDataImp implements GetGoodsData {

	@Autowired
	private GoodsDao goodsDao;
	
	@Override
	public List<GoodsTypeEntity> getTopParent() {
		// TODO Auto-generated method stub
		return goodsDao.getTopParent();
	}

	@Override
	public List<GoodsEntity> getGoodsEntityRecommend(String parent_id,Integer start) {
		// TODO Auto-generated method stub
		return goodsDao.getGoodsEntityRecommend(parent_id,start);
	}

}
