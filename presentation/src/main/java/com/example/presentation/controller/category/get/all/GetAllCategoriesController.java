package com.example.presentation.controller.category.get.all;


import com.example.domain.input_boundary.category.get.all.GetAllCategoriesInputBoundary;
import com.example.domain.input_boundary.category.get.all.GetAllCategoriesRequest;
import com.example.domain.output_boundary.category.get.all.GetAllCategoriesOutputBoundary;
import com.example.presentation.ResponseViewModel;
import com.example.presentation.presenter.category.GetAllCategoriesPresenter;
import com.example.presentation.viewmodel.category.GetAllCategoriesViewModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/categories")
public class GetAllCategoriesController {
    private final GetAllCategoriesInputBoundary usecase;
    private final GetAllCategoriesOutputBoundary presenter;

    public GetAllCategoriesController(GetAllCategoriesInputBoundary usecase,
                                      GetAllCategoriesOutputBoundary presenter) {
        this.usecase = usecase;
        this.presenter = presenter;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseViewModel<GetAllCategoriesViewModel> getAllCategories() {
        usecase.execute(GetAllCategoriesRequest.builder().build());

        return ResponseViewModel.<GetAllCategoriesViewModel>builder()
                .hasError(false)
                .message(ResponseViewModel.SUCCESS_MESSAGE)
                .data(((GetAllCategoriesPresenter) presenter).getViewModel())
                .build();
    }
}
