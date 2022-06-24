package com.example.presentation.presenter.category;

import com.example.domain.output_boundary.category.get.by_name.GetCategoryByNameOutputBoundary;
import com.example.domain.output_boundary.category.get.by_name.GetCategoryByNameResponse;
import com.example.presentation.viewmodel.category.GetCategoryByNameViewModel;

public class GetCategoryByNamePresenter implements GetCategoryByNameOutputBoundary {
    private GetCategoryByNameViewModel viewModel;

    public GetCategoryByNameViewModel getViewModel() {
        return viewModel;
    }

    @Override
    public void present(GetCategoryByNameResponse response) {
        viewModel = GetCategoryByNameViewModel.builder()
                .id(response.id().toString())
                .name(response.name())
                .build();
    }
}
