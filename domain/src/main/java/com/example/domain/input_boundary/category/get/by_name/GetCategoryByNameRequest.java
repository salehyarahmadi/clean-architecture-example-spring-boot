package com.example.domain.input_boundary.category.get.by_name;


import lombok.Builder;

public record GetCategoryByNameRequest(String name) {
    @Builder
    public GetCategoryByNameRequest {
    }
}
