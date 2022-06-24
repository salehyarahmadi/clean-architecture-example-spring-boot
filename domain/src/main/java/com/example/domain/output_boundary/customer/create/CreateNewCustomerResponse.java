package com.example.domain.output_boundary.customer.create;

import lombok.Builder;

public record CreateNewCustomerResponse(
        Long id,
        String firstName,
        String lastName
) {
    @Builder
    public CreateNewCustomerResponse {
    }
}
