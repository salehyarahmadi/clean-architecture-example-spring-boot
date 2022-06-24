package com.example.domain.usecase.customer;

import com.example.domain.entity.customer.Customer;
import com.example.domain.input_boundary.customer.get.all.GetAllCustomersInputBoundary;
import com.example.domain.input_boundary.customer.get.all.GetAllCustomersRequest;
import com.example.domain.output_boundary.customer.get.all.CustomerResponse;
import com.example.domain.output_boundary.customer.get.all.GetAllCustomersOutputBoundary;
import com.example.domain.output_boundary.customer.get.all.GetAllCustomersResponse;
import com.example.domain.dao.customer.CustomerDao;

import java.util.List;
import java.util.stream.Collectors;

public class GetAllCustomersUseCase implements GetAllCustomersInputBoundary {
    private final CustomerDao customerDao;
    private final GetAllCustomersOutputBoundary presenter;

    public GetAllCustomersUseCase(CustomerDao customerDao,
                                  GetAllCustomersOutputBoundary presenter) {
        this.customerDao = customerDao;
        this.presenter = presenter;
    }

    @Override
    public void execute(GetAllCustomersRequest request) {
        List<Customer> customers = getAllCustomers(request);

        GetAllCustomersResponse responseModel = GetAllCustomersResponse
                .builder()
                .customers(customers.stream().map(
                        customer -> CustomerResponse.builder()
                                .id(customer.getId())
                                .firstName(customer.getFirstName())
                                .lastName(customer.getLastName())
                                .build()
                ).collect(Collectors.toList()))
                .build();
        presenter.present(responseModel);
    }

    private List<Customer> getAllCustomers(GetAllCustomersRequest request) {
        return customerDao.getAllCustomers();
    }
}
