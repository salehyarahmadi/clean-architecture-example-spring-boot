package com.example.domain.output_boundary.customer.patch;

import lombok.Builder;

public record PatchCustomerResponse(
        Long id,
        String firstName,
        String lastName) {
    @Builder
    public PatchCustomerResponse {
    }
}
