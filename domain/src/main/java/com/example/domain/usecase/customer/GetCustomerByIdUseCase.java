package com.example.domain.usecase.customer;

import com.example.domain.entity.customer.Customer;
import com.example.domain.input_boundary.customer.get.by_id.GetCustomerInputBoundary;
import com.example.domain.input_boundary.customer.get.by_id.GetCustomerRequest;
import com.example.domain.output_boundary.customer.get.by_id.GetCustomerOutputBoundary;
import com.example.domain.output_boundary.customer.get.by_id.GetCustomerResponse;
import com.example.domain.dao.customer.CustomerDao;

import java.util.Optional;


public class GetCustomerByIdUseCase implements GetCustomerInputBoundary {
    private final CustomerDao customerDao;
    private final GetCustomerOutputBoundary presenter;

    public GetCustomerByIdUseCase(CustomerDao customerDao,
                                  GetCustomerOutputBoundary presenter) {
        this.customerDao = customerDao;
        this.presenter = presenter;
    }

    @Override
    public void execute(GetCustomerRequest request) {
        Optional<Customer> customer = getCustomer(request);
        if (customer.isEmpty()) {
            throw new CustomerDao.CustomerNotFoundException();
        }
        GetCustomerResponse responseModel = GetCustomerResponse.builder()
                .id(customer.get().getId())
                .firstName(customer.get().getFirstName())
                .lastName(customer.get().getLastName())
                .build();
        presenter.present(responseModel);
    }

    private Optional<Customer> getCustomer(GetCustomerRequest request) {
        return customerDao.getCustomerById(request.id());
    }
}
