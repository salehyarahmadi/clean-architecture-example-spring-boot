package com.example.presentation.viewmodel.customer;

import lombok.Builder;

public record CustomerViewModel(
        String id,
        String firstName,
        String lastName) {
    @Builder
    public CustomerViewModel {
    }
}