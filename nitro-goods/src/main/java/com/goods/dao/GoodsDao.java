package com.goods.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.common.mybatis.BaseDao;
import com.nitro.entity.GoodsEntity;
import com.nitro.entity.GoodsTypeEntity;
@Mapper
public interface GoodsDao extends  BaseDao {
	@Select("SELECT type.name,type.id FROM tb_goods_type AS type WHERE  type.parent_id=0 AND type.status=1 AND type.is_parent =1")
	List<GoodsTypeEntity> getTopParent();
	
	@Select("SELECT goods.id,goods.title,goods.price,goods.image FROM tb_goods AS goods  WHERE parent_id = #{parent_id} ORDER BY goods.sell_point limit #{start},4")
	List<GoodsEntity> getGoodsEntityRecommend(@Param("parent_id") String parent_id,@Param("start")	Integer start);
	
	
	
}
