package com.goods.manage;

import java.util.List;

import com.nitro.entity.GoodsEntity;
import com.nitro.entity.GoodsTypeEntity;

public interface GetGoodsData {

	List<GoodsTypeEntity> getTopParent();
	
	List<GoodsEntity> getGoodsEntityRecommend(String parent_id,Integer start);
}
