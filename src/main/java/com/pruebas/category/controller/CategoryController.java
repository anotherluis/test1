package com.pruebas.category.controller;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pruebas.category.model.Category;
import com.pruebas.category.service.CategoryService;
import com.pruebas.common.ApiResponse;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Category>> createCategory(@RequestBody Category category) {
        try {
            Category datos = categoryService.createCategory(category);
            return ApiResponse.success(datos);
        } catch (DataIntegrityViolationException | ConstraintViolationException e) {
            HttpStatus status = HttpStatus.BAD_REQUEST;
            Category cate = Category.category();
            String errorMessage = "Error de violación de integridad: " + e.getMessage();
            return ApiResponse.error(status, errorMessage, cate);
        }
    }

    @PostMapping("/update")
    public Category updateCategory(@RequestBody Category category) {
        return categoryService.updateCategory(category.getId(), category);
    }

    @GetMapping
    public List<Category> getLisCategory() {
        return categoryService.getAllCategorys();
    }

    @GetMapping("/show/")
    public Optional<Category> getCategoryById(@RequestBody Category category) {
        return categoryService.getCategoryById(category);
    }

    @DeleteMapping("/deleteall")
    public String deleteAllCategorys() {
        categoryService.deleteAllCategorys();
        return "All users have been deleted successfully.";
    }

    @PostMapping("/delete")
    public void deleteById(@RequestBody Category category) {
        categoryService.deleteCategory(category);
    }
}
