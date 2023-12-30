package com.anudip.yourcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anudip.yourcare.dto.ReviewDto;
import com.anudip.yourcare.entity.Doctor;
import com.anudip.yourcare.entity.Review;
import com.anudip.yourcare.service.impl.DoctorServiceImpl;
import com.anudip.yourcare.service.impl.ReviewServiceImpl;


@RestController
public class ReviewController {

			@Autowired
			ReviewServiceImpl reviewServiceImpl;
			
			@Autowired
			DoctorServiceImpl doctorServiceImpl;
	
	
			//This will get the request to create the new Review
			@PostMapping("/review/{docName}/create")
			public Review addDoctorByDoctorName(@RequestBody Review review,@PathVariable String docName)
			{
				Doctor doc = doctorServiceImpl.getDoctorByName(docName);
				review.setDoctor(doc);
				return reviewServiceImpl.createReview(review);
			}
			
			//This will get the request to print all the existing Review
			@GetMapping("/review/allreview")
			public List<ReviewDto> getAllUser(@RequestBody Review review)
			{
				return reviewServiceImpl.getAllReview();
			}
			
			
			//This will get the request to print the Review by using id
			@GetMapping("/review/reviewById/{id}")
			public ReviewDto findReviewById(@PathVariable int id)
			{
				return reviewServiceImpl.getReviewById(id);
			}
			
			//This will get the request to find the existing review 
			@GetMapping("/review/reviewByName/{fname}")
			public ReviewDto findByName(@PathVariable String fname)
			{
				return reviewServiceImpl.getReviewByName(fname);
			}
			
			//This will Get the request to update the existing doctor in the DB
			@PutMapping("/review/update")
			public Review updateDoctor(@RequestBody Review review)
			{
				return reviewServiceImpl.updateReviewByName(review);
			}
			
			@DeleteMapping("/review/delete/{fname}")
			public String deleteByName(@PathVariable String fname)
			{
				String msg = reviewServiceImpl.deleteReviewByName(fname);
				return msg;
			}
			
			
			//get list of reviews given by any person to doctors by using there fname
			@GetMapping("/reviewlist/{fName}/user")
			public List<Review> listByFname(@PathVariable String fName)
			{
				return reviewServiceImpl.getListReviewByFname(fName);
			}
			
			@GetMapping("/reviewlist/{fName}/doctor")
			public List<Review> ListByDoctorsFname(@PathVariable String fName)
			{
				return reviewServiceImpl.getListReviewByDoctorsFname(fName);
			}
}
