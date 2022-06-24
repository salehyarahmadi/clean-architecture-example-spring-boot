package com.example.presentation.controller.customer.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Getter
public class NewCustomerCommand {
    private String firstName;
    private String lastName;
}
