package com.example.presentation.controller.customer.patch;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PatchCustomerCommand {
    private String firstName;
    private String lastName;
}
