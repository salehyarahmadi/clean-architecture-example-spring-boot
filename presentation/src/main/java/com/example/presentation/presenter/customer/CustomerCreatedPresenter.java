package com.example.presentation.presenter.customer;

import com.example.domain.output_boundary.customer.create.CreateNewCustomerResponse;
import com.example.domain.output_boundary.customer.create.CustomerCreatedOutputBoundary;
import com.example.presentation.viewmodel.customer.CustomerCreatedViewModel;

public class CustomerCreatedPresenter implements CustomerCreatedOutputBoundary {
    private CustomerCreatedViewModel viewModel;

    public CustomerCreatedViewModel getViewModel() {
        return viewModel;
    }

    @Override
    public void present(CreateNewCustomerResponse response) {
        viewModel = CustomerCreatedViewModel.builder()
                .id(response.id().toString())
                .firstName(response.firstName())
                .lastName(response.lastName())
                .build();
    }
}
