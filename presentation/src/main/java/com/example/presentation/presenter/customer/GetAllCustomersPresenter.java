package com.example.presentation.presenter.customer;

import com.example.domain.output_boundary.customer.get.all.GetAllCustomersOutputBoundary;
import com.example.domain.output_boundary.customer.get.all.GetAllCustomersResponse;
import com.example.presentation.viewmodel.customer.CustomerViewModel;
import com.example.presentation.viewmodel.customer.GetAllCustomersViewModel;

import java.util.stream.Collectors;

public class GetAllCustomersPresenter implements GetAllCustomersOutputBoundary {
    private GetAllCustomersViewModel viewModel;

    public GetAllCustomersViewModel getViewModel() {
        return viewModel;
    }


    @Override
    public void present(GetAllCustomersResponse response) {
        viewModel = GetAllCustomersViewModel.builder()
                .customers(response.customers().stream().map(
                        customerResponse -> CustomerViewModel.builder()
                                .id(customerResponse.id().toString())
                                .firstName(customerResponse.firstName())
                                .lastName(customerResponse.lastName())
                                .build()
                ).collect(Collectors.toList()))
                .build();

    }
}
