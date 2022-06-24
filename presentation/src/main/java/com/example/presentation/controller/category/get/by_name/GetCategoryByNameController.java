package com.example.presentation.controller.category.get.by_name;

import com.example.domain.input_boundary.category.get.by_name.GetCategoryByNameInputBoundary;
import com.example.domain.input_boundary.category.get.by_name.GetCategoryByNameRequest;
import com.example.domain.output_boundary.category.get.by_name.GetCategoryByNameOutputBoundary;
import com.example.presentation.ResponseViewModel;
import com.example.presentation.presenter.category.GetCategoryByNamePresenter;
import com.example.presentation.viewmodel.category.GetCategoryByNameViewModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categories")
public class GetCategoryByNameController {
    private final GetCategoryByNameInputBoundary usecase;
    private final GetCategoryByNameOutputBoundary presenter;

    public GetCategoryByNameController(GetCategoryByNameInputBoundary usecase,
                                       GetCategoryByNameOutputBoundary presenter) {
        this.usecase = usecase;
        this.presenter = presenter;
    }

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseViewModel<GetCategoryByNameViewModel> getCategoryByName(@PathVariable String name) {
        usecase.execute(
                GetCategoryByNameRequest.builder()
                        .name(name)
                        .build()
        );

        return ResponseViewModel.<GetCategoryByNameViewModel>builder()
                .hasError(false)
                .message(ResponseViewModel.SUCCESS_MESSAGE)
                .data(((GetCategoryByNamePresenter) presenter).getViewModel())
                .build();
    }
}
