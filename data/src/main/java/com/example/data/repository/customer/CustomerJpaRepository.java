package com.example.data.repository.customer;

import com.example.data.model.customer.CustomerDB;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerJpaRepository extends JpaRepository<CustomerDB, Long> {
}
