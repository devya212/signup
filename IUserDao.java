package com.nucleus.dao;

import com.nucleus.model.User;

public interface IUserDao {
	public boolean checkValidUser(User user);
	public void insertDetails(User user);
	public boolean checkValidLogin(User user);


}
