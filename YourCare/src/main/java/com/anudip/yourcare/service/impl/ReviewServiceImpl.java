package com.anudip.yourcare.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.yourcare.dto.ReviewDto;
import com.anudip.yourcare.entity.Review;
import com.anudip.yourcare.repository.DoctorRepository;
import com.anudip.yourcare.repository.ReviewRepository;
import com.anudip.yourcare.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	ReviewRepository reviweRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
    DoctorRepository doctorRepository;
	
	@Override
	public Review createReview(Review review) {
		
//		Doctor doctor = review.getDoctor(doctor.getId());
//		review.setDoctor(doctor);
		
		return reviweRepository.save(review);
	}

	@Override
	public List<ReviewDto> getAllReview() {
		List<Review> reviews = reviweRepository.findAll();
		return reviews.stream().map(review -> modelMapper.map(review, ReviewDto.class)).collect(Collectors.toList());
	}

	@Override
	public ReviewDto getReviewById(int id) {
		
		Optional<Review> existingReview = reviweRepository.findById(id);
		if(existingReview.isPresent())
		{
			ReviewDto reviewDto = modelMapper.map(existingReview, ReviewDto.class);
			return reviewDto;
		}
		return null;
	}

	@Override
	public ReviewDto getReviewByName(String fname) {
		
		Review existingReview = reviweRepository.findByFname(fname);
		
		ReviewDto reviewDto = modelMapper.map(existingReview, ReviewDto.class);
		return reviewDto;
	}

	@Override
	public Review updateReviewByName(Review review) {
		
		Review existingReview = reviweRepository.findByFname(review.getFname());
		
		existingReview.setLname(review.getLname());
		existingReview.setRating(review.getRating());
		existingReview.setComments(review.getComments());
		existingReview.setDoctor(review.getDoctor());
	
		return reviweRepository.save(existingReview);
	}

	@Override
	public String deleteReviewByName(String fname) {
		
		Review checkReview = reviweRepository.findByFname(fname);
		
		if(checkReview == null)
		{
			return null;
		}
		reviweRepository.deleteById(checkReview.getReviewid());
		
		return "The record is deleted Successfully";
	}

	@Override
	public List<Review> getListReviewByFname(String fname) {
		
		List<Review> reviewList = reviweRepository.findReviewByFname(fname);
		return reviewList;
	}

	@Override
	public List<Review> getListReviewByDoctorsFname(String fname) {
		List<Review> reviewList = reviweRepository.findDoctorByFname(fname);
		return reviewList;
	}

}
