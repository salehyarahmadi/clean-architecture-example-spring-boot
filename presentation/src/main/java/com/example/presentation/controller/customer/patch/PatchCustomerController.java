package com.example.presentation.controller.customer.patch;

import com.example.domain.input_boundary.customer.patch.PatchCustomerInputBoundary;
import com.example.domain.input_boundary.customer.patch.PatchCustomerRequest;
import com.example.domain.output_boundary.customer.patch.PatchCustomerOutputBoundary;
import com.example.presentation.ResponseViewModel;
import com.example.presentation.presenter.customer.CustomerPatchedPresenter;
import com.example.presentation.viewmodel.customer.CustomerPatchedViewModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class PatchCustomerController {
    private final PatchCustomerInputBoundary usecase;
    private final PatchCustomerOutputBoundary presenter;

    public PatchCustomerController(PatchCustomerInputBoundary usecase,
                                   PatchCustomerOutputBoundary presenter) {
        this.usecase = usecase;
        this.presenter = presenter;
    }

    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseViewModel<CustomerPatchedViewModel> execute(
            @PathVariable Long id,
            @RequestBody PatchCustomerCommand request
    ) {
        usecase.execute(
                PatchCustomerRequest.builder()
                        .id(id)
                        .firstName(request.getFirstName())
                        .lastName(request.getLastName())
                        .build()
        );

        return ResponseViewModel.<CustomerPatchedViewModel>builder()
                .hasError(false)
                .message(ResponseViewModel.SUCCESS_MESSAGE)
                .data(((CustomerPatchedPresenter) presenter).getViewModel())
                .build();
    }
}
