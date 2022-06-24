package com.example.data.model.customer;


import com.example.domain.entity.customer.Customer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Setter
@Getter
@Entity
public class CustomerDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    public Customer mapToEntity() {
        return new Customer(this.id, this.firstName, this.lastName);
    }

    public static CustomerDB fromCustomerForCreate(Customer customer) {
        CustomerDB customerDB = new CustomerDB();
        customerDB.setFirstName(customer.getFirstName());
        customerDB.setLastName(customer.getLastName());
        return customerDB;
    }

    public static CustomerDB fromCustomerForUpdate(Customer customer) {
        CustomerDB customerDB = new CustomerDB();
        customerDB.setId(customer.getId());
        customerDB.setFirstName(customer.getFirstName());
        customerDB.setLastName(customer.getLastName());
        return customerDB;
    }
}