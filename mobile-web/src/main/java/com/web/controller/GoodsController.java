package com.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.validator.internal.util.privilegedactions.GetResolvedMemberMethods;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nitro.entity.GoodsEntity;
import com.nitro.entity.GoodsTypeEntity;
import com.web.base.controller.BaseController;
import com.web.base.controller.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController extends GoodsService{

	@GetMapping("/index.html")
	public String index(HttpServletRequest request) {
		
		List<GoodsTypeEntity> goodsTypeEntities=getTopParent();
		request.setAttribute("typeEntities", goodsTypeEntities);
		Map<String,List> map = new HashMap<String,List>();
		for (int i = 0; i < goodsTypeEntities.size(); i++) {
			map.put(goodsTypeEntities.get(i).getName(), getGoodsEntityRecommend(goodsTypeEntities.get(i).getId().toString(),0));
		}
		request.setAttribute("goodsEntities", map);

		return "index";
	}
	
}
