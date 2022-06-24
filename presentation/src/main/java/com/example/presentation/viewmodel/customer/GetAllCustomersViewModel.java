package com.example.presentation.viewmodel.customer;

import lombok.Builder;

import java.util.List;

public record GetAllCustomersViewModel(List<CustomerViewModel> customers) {
    @Builder
    public GetAllCustomersViewModel {
    }
}