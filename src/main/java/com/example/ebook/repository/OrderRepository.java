package com.example.ebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ebook.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
