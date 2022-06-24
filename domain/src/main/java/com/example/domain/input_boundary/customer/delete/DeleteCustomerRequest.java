package com.example.domain.input_boundary.customer.delete;

import lombok.Builder;


public record DeleteCustomerRequest(Long id) {
    @Builder
    public DeleteCustomerRequest {
    }
}
