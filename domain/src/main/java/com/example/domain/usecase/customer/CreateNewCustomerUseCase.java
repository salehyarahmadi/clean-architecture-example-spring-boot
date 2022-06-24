package com.example.domain.usecase.customer;

import com.example.domain.entity.customer.Customer;
import com.example.domain.input_boundary.customer.create.CreateNewCustomerInputBoundary;
import com.example.domain.input_boundary.customer.create.CreateNewCustomerRequest;
import com.example.domain.output_boundary.customer.create.CreateNewCustomerResponse;
import com.example.domain.output_boundary.customer.create.CustomerCreatedOutputBoundary;
import com.example.domain.dao.customer.CustomerDao;


public class CreateNewCustomerUseCase implements CreateNewCustomerInputBoundary {
    private final CustomerDao customerDao;
    private final CustomerCreatedOutputBoundary presenter;

    public CreateNewCustomerUseCase(CustomerDao customerDao,
                                    CustomerCreatedOutputBoundary presenter) {
        this.customerDao = customerDao;
        this.presenter = presenter;
    }

    @Override
    public void execute(CreateNewCustomerRequest request) {
        validateCustomer(request);
        Customer savedCustomer = createCustomer(request);

        CreateNewCustomerResponse responseModel = new CreateNewCustomerResponse(
                savedCustomer.getId(),
                savedCustomer.getFirstName(),
                savedCustomer.getLastName()
        );
        presenter.present(responseModel);
    }

    private void validateCustomer(CreateNewCustomerRequest request) {
        if (request.firstName().equals("")) {
            throw new CustomerDao.CustomerFirstNameIsEmpty();
        }

        if (request.lastName().equals("")) {
            throw new CustomerDao.CustomerLastNameIsEmpty();
        }
    }

    private Customer createCustomer(CreateNewCustomerRequest request) {
        return customerDao.createNewCustomer(
                new Customer(
                        request.firstName(),
                        request.lastName()
                )
        );
    }
}
