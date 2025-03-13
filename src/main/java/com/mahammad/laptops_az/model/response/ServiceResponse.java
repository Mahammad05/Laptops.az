package com.mahammad.laptops_az.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceResponse<T> {

    private boolean success;
    private String message;
    private T data;

    public static <T> ServiceResponse<T> success(T data) {
        return ServiceResponse.<T>builder()
                .success(true)
                .message("success")
                .data(data)
                .build();
    }

    public static <T> ServiceResponse<T> success(String message, T data) {
        return ServiceResponse.<T>builder()
                .success(true)
                .message(message)
                .data(data)
                .build();
    }

    public static <T> ServiceResponse<T> failure(String message) {
        return ServiceResponse.<T>builder()
                .success(false)
                .message(message)
                .data(null)
                .build();
    }
}