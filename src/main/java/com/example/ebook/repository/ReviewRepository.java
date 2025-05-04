package com.example.ebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ebook.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
