package com.myVue.service;

import java.util.List;

import com.myVue.bean.UserEntity;

public interface UserService {

	List<UserEntity> getUserList();
	
	UserEntity getUserByUserId(String userId);


}
