package com.example.domain.dao.category;

import com.example.domain.entity.category.Category;
import com.example.domain.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface CategoryDao {
    List<Category> getAllCategories();

    Optional<Category> getCategoryByName(String name);

    class CategoryNotFoundException extends RuntimeException implements NotFoundException {
    }
}
