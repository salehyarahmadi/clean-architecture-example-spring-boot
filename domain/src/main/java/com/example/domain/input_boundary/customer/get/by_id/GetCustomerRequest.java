package com.example.domain.input_boundary.customer.get.by_id;


import lombok.Builder;

public record GetCustomerRequest(Long id) {
    @Builder
    public GetCustomerRequest {

    }
}
