package com.alterra.capstone.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BaseResponse<T> {
    private Boolean success;
    private String message;
    private T data;
}
