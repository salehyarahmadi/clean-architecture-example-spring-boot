package com.example.presentation.controller.customer.delete;

import com.example.domain.input_boundary.customer.delete.DeleteCustomerInputBoundary;
import com.example.domain.input_boundary.customer.delete.DeleteCustomerRequest;
import com.example.domain.output_boundary.customer.delete.DeleteCustomerOutputBoundary;
import com.example.presentation.ResponseViewModel;
import com.example.presentation.presenter.customer.CustomerDeletedPresenter;
import com.example.presentation.viewmodel.customer.CustomerDeletedViewModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class DeleteCustomerController {
    private final DeleteCustomerInputBoundary usecase;
    private final DeleteCustomerOutputBoundary presenter;

    public DeleteCustomerController(DeleteCustomerInputBoundary usecase,
                                    DeleteCustomerOutputBoundary presenter) {
        this.usecase = usecase;
        this.presenter = presenter;
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseViewModel<CustomerDeletedViewModel> execute(@PathVariable Long id) {
        usecase.execute(
                DeleteCustomerRequest.builder()
                        .id(id)
                        .build()
        );

        return ResponseViewModel.<CustomerDeletedViewModel>builder()
                .hasError(false)
                .message(ResponseViewModel.SUCCESS_MESSAGE)
                .data(((CustomerDeletedPresenter) presenter).getViewModel())
                .build();
    }
}
