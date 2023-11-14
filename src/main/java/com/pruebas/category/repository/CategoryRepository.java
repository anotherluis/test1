package com.pruebas.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pruebas.category.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}