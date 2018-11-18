package com.myVue.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myVue.bean.UserEntity;
import com.myVue.mapper.UserMapper;
import com.myVue.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;
	
	@Override
	public List<UserEntity> getUserList() {
		return mapper.getUserList();
	}

	@Override
	public UserEntity getUserByUserId(String userId) {
		return mapper.getUserByUserId(userId);
	}

}
