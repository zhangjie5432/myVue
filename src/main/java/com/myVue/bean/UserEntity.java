package com.myVue.bean;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @author zhangjie
 *
 */
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 4449178512857503387L;

	private int id;

	private String userId;

	private String userName;

	private String passWord;

	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

}
