package com.example.domain.usecase.customer;

import com.example.domain.entity.customer.Customer;
import com.example.domain.input_boundary.customer.update.UpdateCustomerInputBoundary;
import com.example.domain.input_boundary.customer.update.UpdateCustomerRequest;
import com.example.domain.output_boundary.customer.update.UpdateCustomerOutputBoundary;
import com.example.domain.output_boundary.customer.update.UpdateCustomerResponse;
import com.example.domain.dao.customer.CustomerDao;


public class UpdateCustomerUseCase implements UpdateCustomerInputBoundary {
    private final CustomerDao customerDao;
    private final UpdateCustomerOutputBoundary presenter;

    public UpdateCustomerUseCase(CustomerDao customerDao,
                                 UpdateCustomerOutputBoundary presenter) {
        this.customerDao = customerDao;
        this.presenter = presenter;
    }

    @Override
    public void execute(UpdateCustomerRequest request) {
        validateCustomer(request);
        Customer updatedCustomer = updateCustomer(request);

        UpdateCustomerResponse responseModel = UpdateCustomerResponse.builder()
                .id(updatedCustomer.getId())
                .firstName(updatedCustomer.getFirstName())
                .lastName(updatedCustomer.getLastName())
                .build();
        presenter.present(responseModel);
    }

    private void validateCustomer(UpdateCustomerRequest request) {
        if(customerDao.getCustomerById(request.id()).isEmpty()) {
            throw new CustomerDao.CustomerNotFoundException();
        }
        if (request.firstName().equals("")) {
            throw new CustomerDao.CustomerFirstNameIsEmpty();
        }

        if (request.lastName().equals("")) {
            throw new CustomerDao.CustomerLastNameIsEmpty();
        }
    }

    private Customer updateCustomer(UpdateCustomerRequest request) {
        return customerDao.updateCustomer(
                new Customer(
                        request.id(),
                        request.firstName(),
                        request.lastName()
                )
        );
    }
}
