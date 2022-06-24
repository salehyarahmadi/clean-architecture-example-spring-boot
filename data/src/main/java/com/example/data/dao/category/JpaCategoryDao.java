package com.example.data.dao.category;

import com.example.data.repository.category.CategoryJpaRepository;
import com.example.data.model.category.CategoryDB;
import com.example.domain.entity.category.Category;
import com.example.domain.dao.category.CategoryDao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class JpaCategoryDao implements CategoryDao {
    private final CategoryJpaRepository categoryJpaRepository;

    public JpaCategoryDao(CategoryJpaRepository categoryJpaRepository) {
        this.categoryJpaRepository = categoryJpaRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryJpaRepository.findAll()
                .stream()
                .map(CategoryDB::mapToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Category> getCategoryByName(String name) {
        return categoryJpaRepository.findByName(name).map(CategoryDB::mapToEntity);
    }
}
