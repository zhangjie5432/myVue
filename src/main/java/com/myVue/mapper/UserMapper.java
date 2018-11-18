package com.myVue.mapper;

import java.util.List;

import com.myVue.bean.UserEntity;

/**
 * 
 * @author zhangjie
 *
 */
public interface UserMapper {

	List<UserEntity> getUserList();
	
	UserEntity getUserByUserId(String userId);
	
}
