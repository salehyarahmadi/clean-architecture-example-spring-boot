package com.example.presentation.presenter.customer;

import com.example.domain.output_boundary.customer.get.by_id.GetCustomerOutputBoundary;
import com.example.domain.output_boundary.customer.get.by_id.GetCustomerResponse;
import com.example.presentation.viewmodel.customer.GetCustomerViewModel;


public class GetCustomerPresenter implements GetCustomerOutputBoundary {
    private GetCustomerViewModel viewModel;

    public GetCustomerViewModel getViewModel() {
        return viewModel;
    }


    @Override
    public void present(GetCustomerResponse response) {
        viewModel = GetCustomerViewModel.builder()
                .id(response.id().toString())
                .firstName(response.firstName())
                .lastName(response.lastName())
                .build();
    }
}
