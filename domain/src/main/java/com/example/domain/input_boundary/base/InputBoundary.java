package com.example.domain.input_boundary.base;

public interface InputBoundary<T> {
    void execute(T request);
}
