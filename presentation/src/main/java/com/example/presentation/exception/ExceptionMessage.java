package com.example.presentation.exception;

import com.example.domain.dao.category.CategoryDao;
import com.example.domain.dao.customer.CustomerDao;

import java.util.HashMap;
import java.util.Map;

public class ExceptionMessage {
    private ExceptionMessage() {}

    public static Map<Class<?>, String> errors = new HashMap<>();

    static {
        errors.put(CategoryDao.CategoryNotFoundException.class, "category not found with this name");
        errors.put(CustomerDao.CustomerNotFoundException.class, "customer not found with this id");
        errors.put(CustomerDao.CustomerFirstNameIsEmpty.class, "first name must be set");
        errors.put(CustomerDao.CustomerLastNameIsEmpty.class, "last name must be set");
    }
}
