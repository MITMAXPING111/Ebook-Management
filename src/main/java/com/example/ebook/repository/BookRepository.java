package com.example.ebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ebook.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
