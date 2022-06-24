package com.example.presentation.presenter.category;

import com.example.domain.output_boundary.category.get.all.GetAllCategoriesOutputBoundary;
import com.example.domain.output_boundary.category.get.all.GetAllCategoriesResponse;
import com.example.presentation.viewmodel.category.CategoryViewModel;
import com.example.presentation.viewmodel.category.GetAllCategoriesViewModel;

import java.util.stream.Collectors;


public class GetAllCategoriesPresenter implements GetAllCategoriesOutputBoundary {
    private GetAllCategoriesViewModel viewModel;

    public GetAllCategoriesViewModel getViewModel() {
        return viewModel;
    }

    @Override
    public void present(GetAllCategoriesResponse response) {
        viewModel = GetAllCategoriesViewModel.builder()
                .categories(response.categories().stream().map(
                        categoryResponse -> CategoryViewModel.builder()
                                .id(categoryResponse.id().toString())
                                .name(categoryResponse.name())
                                .build()
                ).collect(Collectors.toList()))
                .build();
    }
}
