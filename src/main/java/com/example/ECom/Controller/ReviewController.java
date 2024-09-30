package com.example.ECom.Controller;

import com.example.ECom.Service.ReviewService;
import com.example.ECom.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/getReviews")
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }
    @PostMapping("/Reviews")
    public Review createReview(@RequestBody Review review) {
        return reviewService.createReview(review);
    }


        @PutMapping("/Reviews")
        public Review updateReview(@RequestBody Review newReview){
//            Review review = reviewRepository.findById(id).orElse(null);
//            if (product != null) {
//                review.setText(newReview.getText());
//                review.setReviewDate(newReview.getReviewDate());
//                //Use the save method to update the review in the database
            return reviewService.updateReview(newReview);
        }

    @DeleteMapping("/reviews")
    public String deleteReview(@RequestBody Long id) {
       return reviewService.deleteById(id);
    }
}
