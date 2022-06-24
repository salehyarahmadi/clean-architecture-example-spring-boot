package com.example.data.database;

import com.example.data.dao.category.JpaCategoryDao;
import com.example.data.dao.customer.JpaCustomerDao;
import com.example.data.repository.category.CategoryJpaRepository;
import com.example.data.repository.customer.CustomerJpaRepository;
import com.example.domain.dao.category.CategoryDao;
import com.example.domain.dao.customer.CustomerDao;

public class JpaDatabase implements Database {
    private final CategoryDao categoryDao;
    private final CustomerDao customerDao;

    public JpaDatabase(CategoryJpaRepository categoryJpaRepository,
                       CustomerJpaRepository customerJpaRepository) {
        categoryDao = new JpaCategoryDao(categoryJpaRepository);
        customerDao = new JpaCustomerDao(customerJpaRepository);
    }

    @Override
    public CategoryDao categoryGateway() {
        return categoryDao;
    }

    @Override
    public CustomerDao customerGateway() {
        return customerDao;
    }
}
