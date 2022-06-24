package com.example.domain.input_boundary.customer.update;

import lombok.Builder;


public record UpdateCustomerRequest(
        Long id,
        String firstName,
        String lastName
) {
    @Builder
    public UpdateCustomerRequest {
    }
}
