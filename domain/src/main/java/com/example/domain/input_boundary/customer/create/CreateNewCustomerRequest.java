package com.example.domain.input_boundary.customer.create;

import lombok.Builder;


public record CreateNewCustomerRequest(
        String firstName,
        String lastName
) {
    @Builder
    public CreateNewCustomerRequest {
    }
}

