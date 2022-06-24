package com.example.domain.output_boundary.customer.get.all;

import lombok.Builder;


public record CustomerResponse(
        Long id,
        String firstName,
        String lastName
) {
    @Builder
    public CustomerResponse {
    }
}
