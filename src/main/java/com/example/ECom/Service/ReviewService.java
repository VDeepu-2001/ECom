package com.example.ECom.Service;

import com.example.ECom.model.Review;
import com.example.ECom.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    public Review updateReview(Review newReview) {
        Review review = reviewRepository.findById(newReview.getReviewId()).orElse(null);
        if (review != null) {
            review.setText(newReview.getText());
            review.setReviewDate(newReview.getReviewDate());

            return reviewRepository.save(newReview);
        } else {
            return reviewRepository.save(newReview);
        }
    }

    public String deleteById(Long reviewId) {
        reviewRepository.deleteById(reviewId);
        Review review = reviewRepository.findById(reviewId).orElse(null);
        if (review == null) {
            return "deletion success";
        } else{
            return "deletion failed";
    }
    }
}

