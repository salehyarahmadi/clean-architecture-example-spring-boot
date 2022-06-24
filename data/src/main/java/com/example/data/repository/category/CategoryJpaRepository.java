package com.example.data.repository.category;

import com.example.data.model.category.CategoryDB;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CategoryJpaRepository extends JpaRepository<CategoryDB, Long> {
    Optional<CategoryDB> findByName(String name);
}
