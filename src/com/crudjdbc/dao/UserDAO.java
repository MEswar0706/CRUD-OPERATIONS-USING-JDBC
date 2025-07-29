package com.crudjdbc.dao;

import java.util.ArrayList;

import com.crudjdbc.models.User;

public interface UserDAO {

	ArrayList<User> getAllUsers();

	User getUserById(int userId);

	boolean addUser(User user);

	boolean updateUser(User user);

	boolean deleteUser(int userId);

}
