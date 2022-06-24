package com.example.presentation.viewmodel.category;

import lombok.Builder;

public record GetCategoryByNameViewModel(
        String id,
        String name
) {
    @Builder
    public GetCategoryByNameViewModel {}
}
