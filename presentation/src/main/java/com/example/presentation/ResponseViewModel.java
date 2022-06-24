package com.example.presentation;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ResponseViewModel<T> {
    public static final String SUCCESS_MESSAGE = "success";

    final boolean hasError;
    final String message;
    final T data;

    public ResponseViewModel(boolean hasError, String message, T data) {
        this.hasError = hasError;
        this.message = message;
        this.data = data;
    }
}
