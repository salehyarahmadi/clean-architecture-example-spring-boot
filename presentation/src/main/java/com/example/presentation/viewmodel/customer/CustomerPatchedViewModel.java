package com.example.presentation.viewmodel.customer;

import lombok.Builder;

public record CustomerPatchedViewModel(
        String id,
        String firstName,
        String lastName) {
    @Builder
    public CustomerPatchedViewModel {
    }
}