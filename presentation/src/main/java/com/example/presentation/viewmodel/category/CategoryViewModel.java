package com.example.presentation.viewmodel.category;

import lombok.Builder;

public record CategoryViewModel(String id, String name) {
    @Builder
    public CategoryViewModel {
    }
}
