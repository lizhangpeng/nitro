package com.member.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.common.mybatis.BaseDao;
import com.nitro.entity.UserEntity;

@Mapper
public interface UserDao extends BaseDao  {

	@Select("SELECT user.move_number,user.mailbox,user.move_number,user.id,user.user_naem FROM tb_member AS user WHERE user.`password`=#{password} AND user.move_number=#{move}")
	public UserEntity getUserMoveAndPed(@Param("move") String move,@Param("password") String password);
	@Select("SELECT user.move_number,user.mailbox,user.move_number,user.id,user.user_naem FROM tb_member AS user WHERE id =#{id}")
	public UserEntity getUserMoveAndId(@Param("id") String id);

}
