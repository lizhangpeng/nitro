package com.nitro.entity;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEntity extends TokenEntity {
	private Long id;
	
	private String move_number;
	
	private String password;
	
	private String mailbox;
	
	
	private String user_naem;
	
	private Timestamp register_DataTime;
	
	private Timestamp land_DataTime;

}
