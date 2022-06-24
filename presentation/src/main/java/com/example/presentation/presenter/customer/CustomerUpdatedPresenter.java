package com.example.presentation.presenter.customer;

import com.example.domain.output_boundary.customer.update.UpdateCustomerOutputBoundary;
import com.example.domain.output_boundary.customer.update.UpdateCustomerResponse;
import com.example.presentation.viewmodel.customer.CustomerUpdatedViewModel;

public class CustomerUpdatedPresenter implements UpdateCustomerOutputBoundary {
    private CustomerUpdatedViewModel viewModel;

    public CustomerUpdatedViewModel getViewModel() {
        return viewModel;
    }

    @Override
    public void present(UpdateCustomerResponse response) {
        viewModel = CustomerUpdatedViewModel.builder()
                .id(response.id().toString())
                .firstName(response.firstName())
                .lastName(response.lastName())
                .build();
    }
}
