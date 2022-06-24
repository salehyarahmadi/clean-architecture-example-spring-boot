package com.example.domain.output_boundary.category.get.by_name;

import lombok.Builder;

public record GetCategoryByNameResponse(
        Long id,
        String name
) {
    @Builder
    public GetCategoryByNameResponse {}
}
