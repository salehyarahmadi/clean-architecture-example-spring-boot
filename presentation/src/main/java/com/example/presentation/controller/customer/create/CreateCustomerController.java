package com.example.presentation.controller.customer.create;


import com.example.domain.input_boundary.customer.create.CreateNewCustomerInputBoundary;
import com.example.domain.input_boundary.customer.create.CreateNewCustomerRequest;
import com.example.domain.output_boundary.customer.create.CustomerCreatedOutputBoundary;
import com.example.presentation.ResponseViewModel;
import com.example.presentation.presenter.customer.CustomerCreatedPresenter;
import com.example.presentation.viewmodel.customer.CustomerCreatedViewModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/customers")
public class CreateCustomerController {
    private final CreateNewCustomerInputBoundary usecase;
    private final CustomerCreatedOutputBoundary presenter;

    public CreateCustomerController(CreateNewCustomerInputBoundary usecase,
                                    CustomerCreatedOutputBoundary presenter) {
        this.usecase = usecase;
        this.presenter = presenter;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseViewModel<CustomerCreatedViewModel> execute(@RequestBody NewCustomerCommand request) {
        usecase.execute(
                CreateNewCustomerRequest
                        .builder()
                        .firstName(request.getFirstName())
                        .lastName(request.getLastName())
                        .build()
        );

        return ResponseViewModel.<CustomerCreatedViewModel>builder()
                .hasError(false)
                .message(ResponseViewModel.SUCCESS_MESSAGE)
                .data(((CustomerCreatedPresenter) presenter).getViewModel())
                .build();
    }
}
