package com.example.data.database;

import com.example.domain.dao.category.CategoryDao;
import com.example.domain.dao.customer.CustomerDao;

public interface Database {
    CategoryDao categoryGateway();

    CustomerDao customerGateway();
}
