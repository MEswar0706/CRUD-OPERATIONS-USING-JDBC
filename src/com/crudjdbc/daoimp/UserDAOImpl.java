
package com.crudjdbc.daoimp;

	import java.sql.Connection;
	import java.sql.Timestamp;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;

import com.crudjdbc.dao.UserDAO;
import com.crudjdbc.models.User;
import com.crudjdbc.util.DBConnection;

	public class UserDAOImpl implements UserDAO {

	private static final String insert = "insert into user (name,username,password,email,phone,address,role) " + "values(?,?,?,?,?,?,?)";
	private static final String selectById="select * from user where user_id=?";
	private static final String selectAllUsers="select * from user";
	private static final String deleteById="delete from user where user_id=?";
	private static final String updateDetails="update user set name=?,username=?,password=?,email=?,phone=?,address=?,role=? where user_id=?";
	@Override
	public ArrayList<User> getAllUsers() {
	User user=null;
	ArrayList<User> users=new ArrayList<>();
	try(Connection connection=DBConnection.getConnection();
	Statement statement=connection.createStatement();
	ResultSet res=statement.executeQuery(selectAllUsers);){

	while(res.next()) {
	int id=res.getInt(1);
	String name=res.getString(2);
	String username=res.getString(3);
	String password=res.getString(4);
	String email=res.getString(5);
	String phone=res.getString(6);
	String address=res.getString(7);
	String role=res.getString(8);
	Timestamp createdDate=res.getTimestamp(9);
	user=new User(id,name,username,password,email,phone,address,role,createdDate);
	users.add(user);
	}

	} catch (SQLException e) {
	e.printStackTrace();
	}
	return users;



	}

	@Override
	public User getUserById(int userId) {
	User user=null;
	try(Connection connection=DBConnection.getConnection();
	PreparedStatement preparedStatement=connection.prepareStatement(selectById);){
	preparedStatement.setInt(1, userId);
	ResultSet res=preparedStatement.executeQuery();
	if(res.next()) {
	int id=res.getInt(1);
	String name=res.getString(2);
	String username=res.getString(3);
	String password=res.getString(4);
	String email=res.getString(5);
	String phone=res.getString(6);
	String address=res.getString(7);
	String role=res.getString(8);
	Timestamp createdDate=res.getTimestamp(9);
	user=new User(id,name,username,password,email,phone,address,role,createdDate);
	}

	} catch (SQLException e) {
	e.printStackTrace();
	}
	return user;
	}

	@Override
	public boolean addUser(User user) {
	int inserted=0;

	try (Connection connection = DBConnection.getConnection();
	PreparedStatement preparedStatement = connection.prepareStatement(insert);) {
	preparedStatement.setString(1, user.getName());
	preparedStatement.setString(2, user.getUsername());
	preparedStatement.setString(3, user.getPassword());
	preparedStatement.setString(4, user.getEmail());
	preparedStatement.setString(5, user.getPhone());
	preparedStatement.setString(6, user.getAddress());
	preparedStatement.setString(7, user.getRole());
	inserted= preparedStatement.executeUpdate();


	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	return inserted==1;

	}

	@Override
	public boolean updateUser(User user) {
	int updated=0;
	try(Connection connection=DBConnection.getConnection();
	PreparedStatement preparedStatement=connection.prepareStatement(updateDetails);){
	preparedStatement.setString(1, user.getName());
	preparedStatement.setString(2, user.getUsername());
	preparedStatement.setString(3, user.getPassword());
	preparedStatement.setString(4, user.getEmail());
	preparedStatement.setString(5, user.getPhone());
	preparedStatement.setString(6, user.getAddress());
	preparedStatement.setString(7, user.getRole());
	preparedStatement.setInt(8, user.getId());
	updated=preparedStatement.executeUpdate();

	} catch (SQLException e) {
	e.printStackTrace();
	}
	return updated==1;


	}

	@Override
	public boolean deleteUser(int userId) {
	int deleted=0;
	try(Connection connection=DBConnection.getConnection();
	PreparedStatement preparedStatement=connection.prepareStatement(deleteById);){
	preparedStatement.setInt(1, userId);
	if(getUserById(userId)==null) {
	System.out.println("User id not found");
	}
	deleted=preparedStatement.executeUpdate();

	} catch (SQLException e) {
	e.printStackTrace();
	}
	return deleted==1;



	}

	}
