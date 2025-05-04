package com.example.ebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ebook.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
