package com.example.presentation.viewmodel.customer;

import lombok.Builder;

public record CustomerCreatedViewModel(
        String id,
        String firstName,
        String lastName) {
    @Builder
    public CustomerCreatedViewModel {
    }
}