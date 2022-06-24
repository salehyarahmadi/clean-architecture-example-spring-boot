package com.example.domain.output_boundary.category.get.all;

import lombok.Builder;

public record CategoryResponse(
        Long id,
        String name
) {
    @Builder
    public CategoryResponse {
    }
}