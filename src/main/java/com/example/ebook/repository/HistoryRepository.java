package com.example.ebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ebook.model.History;

public interface HistoryRepository extends JpaRepository<History, Long> {

}
