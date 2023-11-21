package com.pruebas.category.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebas.category.model.Category;
import com.pruebas.category.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // ** Create a new category
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    // ** Get all category
    public List<Category> getAllCategorys() {
        return categoryRepository.findAll();
    }

    // ** Get category by ID
    public Optional<Category> getCategoryById(Category category) {
        Long lonid = (long) category.getId();
        return categoryRepository.findById(lonid);
    }

    // ** Delete all category
    public void deleteAllCategorys() {
        categoryRepository.deleteAll();
    }

    // ** Delete category
    public void deleteCategory(Category category) {
        Long lonid = (long) category.getId();
        categoryRepository.deleteById(lonid);
    }

    // ** Update Category
    public Category updateCategory(Integer id, Category CategoryDetails) {
        Long longValue = (long) id;
        Optional<Category> Category = categoryRepository.findById(longValue);
        if (Category.isPresent()) {
            Category existingCategory = Category.get();
            existingCategory.setName(CategoryDetails.getName());
            return categoryRepository.save(existingCategory);
        }
        return null;
    }

    public Category createOrUpdateCategory(Category categoryDetails) {
        if (categoryDetails.getId() != null) {
            // Si la categoría tiene un ID, intenta actualizarla
            return updateCategory(categoryDetails.getId(), categoryDetails);
        } else {
            // Si la categoría no tiene un ID, intenta crearla
            return createCategory(categoryDetails);
        }
    }

}
