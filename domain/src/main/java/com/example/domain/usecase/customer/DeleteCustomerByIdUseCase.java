package com.example.domain.usecase.customer;

import com.example.domain.input_boundary.customer.delete.DeleteCustomerInputBoundary;
import com.example.domain.input_boundary.customer.delete.DeleteCustomerRequest;
import com.example.domain.output_boundary.customer.delete.DeleteCustomerOutputBoundary;
import com.example.domain.output_boundary.customer.delete.DeleteCustomerResponse;
import com.example.domain.dao.customer.CustomerDao;


public class DeleteCustomerByIdUseCase implements DeleteCustomerInputBoundary {
    private final CustomerDao customerDao;
    private final DeleteCustomerOutputBoundary presenter;

    public DeleteCustomerByIdUseCase(CustomerDao customerDao,
                                     DeleteCustomerOutputBoundary presenter) {
        this.customerDao = customerDao;
        this.presenter = presenter;
    }

    @Override
    public void execute(DeleteCustomerRequest request) {
        if(customerDao.getCustomerById(request.id()).isEmpty()) {
            throw new CustomerDao.CustomerNotFoundException();
        }
        deleteCustomer(request);

        DeleteCustomerResponse responseModel = DeleteCustomerResponse.builder().build();
        presenter.present(responseModel);
    }

    private void deleteCustomer(DeleteCustomerRequest request) {
        customerDao.deleteCustomerById(request.id());
    }
}
