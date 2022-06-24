package com.example.data.dao.customer;

import com.example.data.repository.customer.CustomerJpaRepository;
import com.example.data.model.customer.CustomerDB;
import com.example.domain.entity.customer.Customer;
import com.example.domain.dao.customer.CustomerDao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class JpaCustomerDao implements CustomerDao {
    private final CustomerJpaRepository customerJpaRepository;

    public JpaCustomerDao(CustomerJpaRepository customerJpaRepository) {
        this.customerJpaRepository = customerJpaRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerJpaRepository.findAll()
                .stream()
                .map(CustomerDB::mapToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerJpaRepository.findById(id).map(CustomerDB::mapToEntity);
    }

    @Override
    public Customer createNewCustomer(Customer customer) {
        return customerJpaRepository.save(CustomerDB.fromCustomerForCreate(customer)).mapToEntity();
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerJpaRepository.save(CustomerDB.fromCustomerForUpdate(customer)).mapToEntity();
    }

    @Override
    public Customer patchCustomer(Customer customer) {
        Customer previousCustomer = getCustomerById(customer.getId()).get();
        CustomerDB customerDB = new CustomerDB();
        customerDB.setId(previousCustomer.getId());
        customerDB.setFirstName((customer.getFirstName() != null)
                ? customer.getFirstName()
                : previousCustomer.getFirstName()
        );
        customerDB.setLastName((customer.getLastName() != null)
                ? customer.getLastName()
                : previousCustomer.getLastName()
        );
        return customerJpaRepository.save(customerDB).mapToEntity();
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerJpaRepository.deleteById(id);
    }
}
