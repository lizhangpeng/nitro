package com.nitro.entity;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoodsEntity {
	
	private String title;
	
	private String sell_point;
	
	private Double price;
	
	private Integer num;
	
	private String barcode;
	
	private String image;
	
	private Integer parent_id;
	
	private Integer cid;
	
	private Integer status;
	
	private Timestamp created;
	
	private Timestamp updated;
	
	

}
