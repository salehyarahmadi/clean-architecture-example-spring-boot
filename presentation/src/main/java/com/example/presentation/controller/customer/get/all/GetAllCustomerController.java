package com.example.presentation.controller.customer.get.all;


import com.example.domain.input_boundary.customer.get.all.GetAllCustomersInputBoundary;
import com.example.domain.input_boundary.customer.get.all.GetAllCustomersRequest;
import com.example.domain.output_boundary.customer.get.all.GetAllCustomersOutputBoundary;
import com.example.presentation.ResponseViewModel;
import com.example.presentation.presenter.customer.GetAllCustomersPresenter;
import com.example.presentation.viewmodel.customer.GetAllCustomersViewModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class GetAllCustomerController {
    private final GetAllCustomersInputBoundary usecase;
    private final GetAllCustomersOutputBoundary presenter;

    public GetAllCustomerController(GetAllCustomersInputBoundary usecase,
                                    GetAllCustomersOutputBoundary presenter) {
        this.usecase = usecase;
        this.presenter = presenter;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseViewModel<GetAllCustomersViewModel> execute() {
        usecase.execute(GetAllCustomersRequest.builder().build());

        return ResponseViewModel.<GetAllCustomersViewModel>builder()
                .hasError(false)
                .message(ResponseViewModel.SUCCESS_MESSAGE)
                .data(((GetAllCustomersPresenter) presenter).getViewModel())
                .build();
    }
}
