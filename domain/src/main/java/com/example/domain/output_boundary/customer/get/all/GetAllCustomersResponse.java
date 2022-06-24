package com.example.domain.output_boundary.customer.get.all;

import lombok.Builder;

import java.util.List;


public record GetAllCustomersResponse(List<CustomerResponse> customers) {
    @Builder
    public GetAllCustomersResponse {
    }
}
