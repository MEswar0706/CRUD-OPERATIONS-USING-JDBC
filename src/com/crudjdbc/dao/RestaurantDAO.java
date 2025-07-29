package com.crudjdbc.dao;

import java.util.ArrayList;

import com.crudjdbc.models.Restaurant;

public interface RestaurantDAO {

	ArrayList<Restaurant> getAllRestaurants();

	Restaurant getRestaurantById(int RestaurantId);

	boolean addRestaurant(Restaurant restaurant);

	boolean updateRestaurant(Restaurant restaurant);

	boolean deleteRestaurant(int RestaurantId);

}
