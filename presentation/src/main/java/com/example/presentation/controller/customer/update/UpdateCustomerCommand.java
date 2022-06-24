package com.example.presentation.controller.customer.update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateCustomerCommand {
    private String firstName;
    private String lastName;
}
