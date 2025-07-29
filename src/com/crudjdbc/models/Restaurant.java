package com.crudjdbc.models;





public class Restaurant {
	
	private int restaurantId;
	private String restaurantName;
	private String restaurantAddress;
	private String restaurantContact;
	private String cuisineType;
	private String deliveryTime;
	private int admineUserId;
	private double rating;
	private String isActive;
	private String imagePath;
	
	
	public Restaurant() {
		
	}


	public Restaurant(int restaurantId, String restaurantName, String restaurantAddress, String restaurantContact,
			String cuisineType, String deliveryTime, int admineUserId, double rating, String isActive, String imagePath) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.restaurantAddress = restaurantAddress;
		this.restaurantContact = restaurantContact;
		this.cuisineType = cuisineType;
		this.deliveryTime = deliveryTime;
		this.admineUserId = admineUserId;
		this.rating = rating;
		this.isActive = isActive;
		this.imagePath = imagePath;
	}


	public Restaurant(String restaurantName, String restaurantAddress, String restaurantContact, String cuisineType,
			String deliveryTime, int admineUserId, double rating, String isActive, String imagePath) {
		super();
		this.restaurantName = restaurantName;
		this.restaurantAddress = restaurantAddress;
		this.restaurantContact = restaurantContact;
		this.cuisineType = cuisineType;
		this.deliveryTime = deliveryTime;
		this.admineUserId = admineUserId;
		this.rating = rating;
		this.isActive = isActive;
		this.imagePath = imagePath;
	}
	


	public int getRestaurantId() {
		return restaurantId;
	}


	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}


	public String getRestaurantName() {
		return restaurantName;
	}


	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}


	public String getRestaurantAddress() {
		return restaurantAddress;
	}


	public void setRestaurantAddress(String restaurantAddress) {
		this.restaurantAddress = restaurantAddress;
	}


	public String getRestaurantContact() {
		return restaurantContact;
	}


	public void setRestaurantContact(String restaurantContact) {
		this.restaurantContact = restaurantContact;
	}


	public String getCuisineType() {
		return cuisineType;
	}


	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}


	public String getDeliveryTime() {
		return deliveryTime;
	}


	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}


	public int getAdmineUserId() {
		return admineUserId;
	}


	public void setAdmineUserId(int admineUserId) {
		this.admineUserId = admineUserId;
	}


	public double getRating() {
		return rating;
	}


	public void setRating(double rating) {
		this.rating = rating;
	}


	public String getIsActive() {
		return isActive;
	}


	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}


	public String getImagePath() {
		return imagePath;
	}


	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}


	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName
				+ ", restaurantAddress=" + restaurantAddress + ", restaurantContact=" + restaurantContact
				+ ", cuisineType=" + cuisineType + ", deliveryTime=" + deliveryTime + ", admineUserId=" + admineUserId
				+ ", rating=" + rating + ", isActive=" + isActive + "]";
	}
	
	
	
	
}
