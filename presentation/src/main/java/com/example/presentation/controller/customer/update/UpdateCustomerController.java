package com.example.presentation.controller.customer.update;

import com.example.domain.input_boundary.customer.update.UpdateCustomerInputBoundary;
import com.example.domain.input_boundary.customer.update.UpdateCustomerRequest;
import com.example.domain.output_boundary.customer.update.UpdateCustomerOutputBoundary;
import com.example.presentation.ResponseViewModel;
import com.example.presentation.presenter.customer.CustomerUpdatedPresenter;
import com.example.presentation.viewmodel.customer.CustomerUpdatedViewModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class UpdateCustomerController {
    private final UpdateCustomerInputBoundary usecase;
    private final UpdateCustomerOutputBoundary presenter;

    public UpdateCustomerController(UpdateCustomerInputBoundary usecase,
                                    UpdateCustomerOutputBoundary presenter) {
        this.usecase = usecase;
        this.presenter = presenter;
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseViewModel<CustomerUpdatedViewModel> execute(
            @PathVariable Long id,
            @RequestBody UpdateCustomerCommand request) {
        usecase.execute(
                UpdateCustomerRequest
                        .builder()
                        .id(id)
                        .firstName(request.getFirstName())
                        .lastName(request.getLastName())
                        .build()
        );

        return ResponseViewModel.<CustomerUpdatedViewModel>builder()
                .hasError(false)
                .message(ResponseViewModel.SUCCESS_MESSAGE)
                .data(((CustomerUpdatedPresenter) presenter).getViewModel())
                .build();
    }
}
