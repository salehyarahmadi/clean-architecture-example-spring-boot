package com.example.domain.input_boundary.customer.patch;

import lombok.Builder;


public record PatchCustomerRequest(
        Long id,
        String firstName,
        String lastName
) {
    @Builder
    public PatchCustomerRequest {
    }
}
