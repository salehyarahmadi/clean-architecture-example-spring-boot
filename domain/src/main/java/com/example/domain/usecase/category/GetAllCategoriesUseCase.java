package com.example.domain.usecase.category;

import com.example.domain.entity.category.Category;
import com.example.domain.input_boundary.category.get.all.GetAllCategoriesInputBoundary;
import com.example.domain.input_boundary.category.get.all.GetAllCategoriesRequest;
import com.example.domain.output_boundary.category.get.all.CategoryResponse;
import com.example.domain.output_boundary.category.get.all.GetAllCategoriesOutputBoundary;
import com.example.domain.output_boundary.category.get.all.GetAllCategoriesResponse;
import com.example.domain.dao.category.CategoryDao;

import java.util.List;
import java.util.stream.Collectors;

public class GetAllCategoriesUseCase implements GetAllCategoriesInputBoundary {
    private final GetAllCategoriesOutputBoundary presenter;
    private final CategoryDao categoryDao;

    public GetAllCategoriesUseCase(GetAllCategoriesOutputBoundary presenter,
                                   CategoryDao categoryDao) {
        this.presenter = presenter;
        this.categoryDao = categoryDao;
    }

    @Override
    public void execute(GetAllCategoriesRequest request) {
        List<Category> categories = getAllCategories(request);

        GetAllCategoriesResponse responseModel = GetAllCategoriesResponse
                .builder()
                .categories(categories.stream().map(
                        category -> new CategoryResponse(
                                category.getId(),
                                category.getName()
                        )
                ).collect(Collectors.toList()))
                .build();
        presenter.present(responseModel);
    }

    private List<Category> getAllCategories(GetAllCategoriesRequest request) {
        return categoryDao.getAllCategories();
    }
}
