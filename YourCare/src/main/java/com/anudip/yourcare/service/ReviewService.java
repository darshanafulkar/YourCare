package com.anudip.yourcare.service;

import java.util.List;


import com.anudip.yourcare.dto.ReviewDto;
import com.anudip.yourcare.entity.Review;


public interface ReviewService {


	//Method for creating the Review
	public Review createReview(Review review);
	
	//Methods for getting Review
	public List<ReviewDto> getAllReview();
	
	public ReviewDto getReviewById(int id);
	
	public ReviewDto getReviewByName(String fname);
	
	//Method for Updating Review
	public Review updateReviewByName(Review review);
	
	
	//Method for Deleting the user
	public String deleteReviewByName(String fname);
	
	
	//This will return the list of all reviews created by any person 
	List<Review> getListReviewByFname(String fname);
	
	
	List<Review> getListReviewByDoctorsFname(String fname);
}
