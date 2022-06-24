package com.example.presentation.viewmodel.customer;

import lombok.Builder;

public record CustomerUpdatedViewModel(
        String id,
        String firstName,
        String lastName) {
    @Builder
    public CustomerUpdatedViewModel {
    }
}