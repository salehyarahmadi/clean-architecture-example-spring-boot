package com.example.domain.output_boundary.customer.update;

import lombok.Builder;

public record UpdateCustomerResponse(
        Long id,
        String firstName,
        String lastName) {
    @Builder
    public UpdateCustomerResponse {
    }
}
