package com.example.presentation.viewmodel.customer;

import lombok.Builder;

public record GetCustomerViewModel(
        String id,
        String firstName,
        String lastName) {
    @Builder
    public GetCustomerViewModel {
    }
}
