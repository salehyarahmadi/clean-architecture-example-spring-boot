package com.example.presentation.presenter.customer;

import com.example.domain.output_boundary.customer.delete.DeleteCustomerOutputBoundary;
import com.example.domain.output_boundary.customer.delete.DeleteCustomerResponse;
import com.example.presentation.viewmodel.customer.CustomerDeletedViewModel;

public class CustomerDeletedPresenter implements DeleteCustomerOutputBoundary {
    private CustomerDeletedViewModel viewModel;

    public CustomerDeletedViewModel getViewModel() {
        return viewModel;
    }

    @Override
    public void present(DeleteCustomerResponse response) {
        viewModel = CustomerDeletedViewModel.builder().build();
    }
}
