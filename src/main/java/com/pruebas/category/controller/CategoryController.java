package com.pruebas.category.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pruebas.category.model.Category;
import com.pruebas.category.service.CategoryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @PostMapping("/update")
    public Category updateCategory(@RequestBody Category category) {
        return categoryService.updateCategory(category.getId(), category);
    }

    @GetMapping
    public List<Category> getLisCategory() {
        return categoryService.getAllCategorys();
    }

    @GetMapping("/show/:{id}")
    public Optional<Category> getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @DeleteMapping
    public String deleteAllCategorys() {
        categoryService.deleteAllCategorys();
        return "All users have been deleted successfully.";
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
