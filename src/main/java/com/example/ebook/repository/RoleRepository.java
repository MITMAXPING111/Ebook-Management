package com.example.ebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ebook.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
