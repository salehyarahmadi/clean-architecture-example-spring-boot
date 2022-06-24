package com.example.presentation.viewmodel.category;

import lombok.Builder;

import java.util.List;

public record GetAllCategoriesViewModel(List<CategoryViewModel> categories) {
    @Builder
    public GetAllCategoriesViewModel {
    }
}
