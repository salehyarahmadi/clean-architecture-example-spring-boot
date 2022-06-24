package com.example.presentation.presenter.customer;

import com.example.domain.output_boundary.customer.patch.PatchCustomerOutputBoundary;
import com.example.domain.output_boundary.customer.patch.PatchCustomerResponse;
import com.example.presentation.viewmodel.customer.CustomerPatchedViewModel;

public class CustomerPatchedPresenter implements PatchCustomerOutputBoundary {
    private CustomerPatchedViewModel viewModel;

    public CustomerPatchedViewModel getViewModel() {
        return viewModel;
    }

    @Override
    public void present(PatchCustomerResponse response) {
        viewModel = CustomerPatchedViewModel.builder()
                .id(response.id().toString())
                .firstName(response.firstName())
                .lastName(response.lastName())
                .build();
    }
}
