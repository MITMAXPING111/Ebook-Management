package com.example.ebook.service.review;

import java.util.List;

import com.example.ebook.model.reponseDTO.ReviewResponseDTO;
import com.example.ebook.model.requestDTO.ReviewRequestDTO;

public interface ReviewService {
    ReviewResponseDTO addReview(ReviewRequestDTO request);

    ReviewResponseDTO getReviewById(Long id);

    List<ReviewResponseDTO> getAllReviews();

    ReviewResponseDTO updateReview(Long id, ReviewRequestDTO request);

    void deleteReview(Long id);
}
