package com.example.domain.dao.customer;

import com.example.domain.entity.customer.Customer;
import com.example.domain.exception.BusinessException;
import com.example.domain.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {
    List<Customer> getAllCustomers();

    Optional<Customer> getCustomerById(Long id);

    Customer createNewCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    Customer patchCustomer(Customer customer);

    void deleteCustomerById(Long id);

    class CustomerNotFoundException extends RuntimeException implements NotFoundException {
    }

    class CustomerFirstNameIsEmpty extends RuntimeException implements BusinessException {
    }

    class CustomerLastNameIsEmpty extends RuntimeException implements BusinessException {
    }
}
