package com.example.domain.usecase.category;

import com.example.domain.entity.category.Category;
import com.example.domain.input_boundary.category.get.by_name.GetCategoryByNameInputBoundary;
import com.example.domain.input_boundary.category.get.by_name.GetCategoryByNameRequest;
import com.example.domain.output_boundary.category.get.by_name.GetCategoryByNameOutputBoundary;
import com.example.domain.output_boundary.category.get.by_name.GetCategoryByNameResponse;
import com.example.domain.dao.category.CategoryDao;

import java.util.Optional;

public class GetCategoryByNameUseCase implements GetCategoryByNameInputBoundary {
    private final CategoryDao categoryDao;
    private final GetCategoryByNameOutputBoundary presenter;

    public GetCategoryByNameUseCase(CategoryDao categoryDao,
                                    GetCategoryByNameOutputBoundary presenter) {
        this.categoryDao = categoryDao;
        this.presenter = presenter;
    }

    @Override
    public void execute(GetCategoryByNameRequest request) {
        Optional<Category> category = getCategory(request);
        if (category.isEmpty()) {
            throw new CategoryDao.CategoryNotFoundException();
        }
        GetCategoryByNameResponse responseModel = GetCategoryByNameResponse.builder()
                .id(category.get().getId())
                .name(category.get().getName())
                .build();
        presenter.present(responseModel);
    }

    private Optional<Category> getCategory(GetCategoryByNameRequest request) {
        return categoryDao.getCategoryByName(request.name());
    }
}
