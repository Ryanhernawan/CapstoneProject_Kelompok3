package com.alterra.capstone.entity;


import lombok.Data;

@Data
public class BaseResponse<T> {
    private Boolean success;
    private T data;
}
