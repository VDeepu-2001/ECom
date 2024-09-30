package com.example.ECom.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name="Review_table")
public class Review {
    @Id
    @Column(name = "reviewId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reviewId;
    @Column(name = "text")
    private String text;

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    @Column(name = "review_DATE")
    private Date reviewDate;
}
