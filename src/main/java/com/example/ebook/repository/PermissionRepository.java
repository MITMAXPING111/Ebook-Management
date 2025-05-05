package com.example.ebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ebook.model.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {

}
