package com.example.domain.output_boundary.customer.get.by_id;

import lombok.Builder;

public record GetCustomerResponse(
        Long id,
        String firstName,
        String lastName) {
    @Builder
    public GetCustomerResponse {
    }
}
