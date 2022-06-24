package com.example.domain.output_boundary.category.get.all;

import lombok.Builder;

import java.util.List;


public record GetAllCategoriesResponse(List<CategoryResponse> categories) {
    @Builder
    public GetAllCategoriesResponse {
    }
}
