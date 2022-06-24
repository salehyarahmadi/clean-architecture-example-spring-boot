package com.example.domain.usecase.customer;

import com.example.domain.input_boundary.customer.patch.PatchCustomerInputBoundary;
import com.example.domain.input_boundary.customer.patch.PatchCustomerRequest;
import com.example.domain.output_boundary.customer.patch.PatchCustomerOutputBoundary;
import com.example.domain.output_boundary.customer.patch.PatchCustomerResponse;
import com.example.domain.entity.customer.Customer;
import com.example.domain.dao.customer.CustomerDao;


public class PatchCustomerUseCase implements PatchCustomerInputBoundary {
    private final CustomerDao customerDao;
    private final PatchCustomerOutputBoundary presenter;

    public PatchCustomerUseCase(CustomerDao customerDao,
                                PatchCustomerOutputBoundary presenter) {
        this.customerDao = customerDao;
        this.presenter = presenter;
    }

    @Override
    public void execute(PatchCustomerRequest request) {
        if(customerDao.getCustomerById(request.id()).isEmpty()) {
            throw new CustomerDao.CustomerNotFoundException();
        }
        Customer patchedCustomer = patchCustomer(request);

        PatchCustomerResponse responseModel = PatchCustomerResponse.builder()
                .id(patchedCustomer.getId())
                .firstName(patchedCustomer.getFirstName())
                .lastName(patchedCustomer.getLastName())
                .build();
        presenter.present(responseModel);
    }

    private Customer patchCustomer(PatchCustomerRequest request) {
        return customerDao.patchCustomer(
                new Customer(
                        request.id(),
                        request.firstName(),
                        request.lastName()
                )
        );
    }
}
