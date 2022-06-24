package com.example.presentation.controller.customer.get.by_id;


import com.example.domain.input_boundary.customer.get.by_id.GetCustomerInputBoundary;
import com.example.domain.input_boundary.customer.get.by_id.GetCustomerRequest;
import com.example.domain.output_boundary.customer.get.by_id.GetCustomerOutputBoundary;
import com.example.presentation.ResponseViewModel;
import com.example.presentation.presenter.customer.GetCustomerPresenter;
import com.example.presentation.viewmodel.customer.GetCustomerViewModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class GetCustomerController {
    private final GetCustomerInputBoundary usecase;
    private final GetCustomerOutputBoundary presenter;

    public GetCustomerController(GetCustomerInputBoundary usecase,
                                 GetCustomerOutputBoundary presenter) {
        this.usecase = usecase;
        this.presenter = presenter;
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseViewModel<GetCustomerViewModel> execute(@PathVariable Long id) {
        usecase.execute(GetCustomerRequest.builder().id(id).build());

        return ResponseViewModel.<GetCustomerViewModel>builder()
                .hasError(false)
                .message(ResponseViewModel.SUCCESS_MESSAGE)
                .data(((GetCustomerPresenter) presenter).getViewModel())
                .build();
    }

}
