package com.crudjdbc.daoimp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

import com.crudjdbc.dao.RestaurantDAO;
import com.crudjdbc.models.Restaurant;
import com.crudjdbc.util.DBConnection;

public class RestaurantDAOImpl implements RestaurantDAO {
	
	private static final String insert="insert into restaurant "
			+ "(restaurantName,restaurantAddress,restaurantContact,cuisineType,deliveryTime,adminUserId,rating,isActive,imagePath) "
			+ "values (?,?,?,?,?,?,?,?,?)";
	private static final String selectById="select * from restaurant where restaurantId=?";
	private static final String selectAllUsers="select * from restaurant";
	private static final String deleteById="delete from restaurant where restaurantId=?";
	private static final String updateRestaurant="update restaurant set "
			+ "restaurantName=?,restaurantAddress=?,restaurantContact=?,cuisineType=?,deliveryTime=?,adminUserId=?,rating=?,isActive=? where restaurantId=?";
	

	@Override
	public ArrayList<Restaurant> getAllRestaurants() {
		Restaurant restaurant=null;
		ArrayList<Restaurant> restaurants=new ArrayList<>();
		try(Connection connection=DBConnection.getConnection();
		Statement statement=connection.createStatement();
		ResultSet res=statement.executeQuery(selectAllUsers);){

		while(res.next()) {
		int id=res.getInt(1);
		String restaurantName=res.getString(2);
		String restaurantAddress=res.getString(3);
		String restaurantContact=res.getString(4);
		String cuisineType=res.getString(5);
		String deliveryTime=res.getString(6);
		int admineUserId=res.getInt(7);
		double rating=res.getDouble(8);
		String isActive=res.getString(9);
		String imagepath=res.getString(10);
		restaurant=new Restaurant(id,restaurantName,restaurantAddress,restaurantContact,cuisineType,deliveryTime,admineUserId,rating,isActive,imagepath);
		restaurants.add(restaurant);
		}

		} catch (SQLException e) {
		e.printStackTrace();
		}
		return restaurants;
	}

	@Override
	public Restaurant getRestaurantById(int RestaurantId) {
		// TODO Auto-generated method stub
		Restaurant restaurant=null;
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(selectById);
				){
			    preparedStatement.setInt(1,RestaurantId);
			    ResultSet res=preparedStatement.executeQuery();
				if(res.next()) {
				int id=res.getInt(1);
				String restaurantName=res.getString(2);
				String restaurantAddress=res.getString(3);
				String restaurantContact=res.getString(4);
				String cuisineType=res.getString(5);
				String deliveryTime=res.getString(6);
				int admineUserId=res.getInt(7);
				double rating=res.getDouble(8);
				String isActive=res.getString(9);
				String imagepath=res.getString(10);
				restaurant=new Restaurant(id,restaurantName,restaurantAddress,restaurantContact,cuisineType,deliveryTime,admineUserId,rating,isActive,imagepath);
				}

				} catch (SQLException e) {
				e.printStackTrace();
				}
		
		return restaurant;
	}

	@Override
	public boolean addRestaurant(Restaurant restaurant) {
		int inserted=0;
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(insert)) {
			
			preparedStatement.setString(1,restaurant.getRestaurantName());
			preparedStatement.setString(2,restaurant.getRestaurantAddress());
			preparedStatement.setString(3,restaurant.getRestaurantContact());
			preparedStatement.setString(4,restaurant.getCuisineType());
			preparedStatement.setString(5, restaurant.getDeliveryTime());
			preparedStatement.setInt(6,restaurant.getAdmineUserId());
			preparedStatement.setDouble(7,restaurant.getRating());
			preparedStatement.setString(8,restaurant.getIsActive());
			FileInputStream input=new FileInputStream(restaurant.getImagePath());
			preparedStatement.setBinaryStream(9,input);
			
			inserted=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		return inserted==1;
	}

	@Override
	public boolean updateRestaurant(Restaurant restaurant) {
		int updated=0;
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(updateRestaurant);
				){
				preparedStatement.setString(1,restaurant.getRestaurantName());
				preparedStatement.setString(2,restaurant.getRestaurantAddress());
				preparedStatement.setString(3,restaurant.getRestaurantContact());
				preparedStatement.setString(4,restaurant.getCuisineType());
				preparedStatement.setString(5,restaurant.getDeliveryTime());
				preparedStatement.setInt(6,restaurant.getAdmineUserId());
				preparedStatement.setDouble(7,restaurant.getRating());
				preparedStatement.setString(8,restaurant.getIsActive());
				preparedStatement.setInt(9,restaurant.getRestaurantId());
				updated=preparedStatement.executeUpdate();
				}

				catch (SQLException e) {
				e.printStackTrace();
				}
		
		
		return updated==1;
	}

	@Override
	public boolean deleteRestaurant(int RestaurantId) {
		// TODO Auto-generated method stub
		int deleted=0;
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(deleteById);
				){
			    preparedStatement.setInt(1,RestaurantId);
			    deleted=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deleted==1;
	}
	
}
