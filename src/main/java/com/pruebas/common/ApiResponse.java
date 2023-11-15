package com.pruebas.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponse<T> {

    private boolean success;
    private HttpStatus status;
    private String message;
    private T data;

    public ApiResponse(boolean success, HttpStatus status, String message, T data) {
        this.success = success;
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseEntity<ApiResponse<T>> success(T data) {
        ApiResponse<T> response = new ApiResponse<>(true, HttpStatus.OK, "Success", data);
        return ResponseEntity.ok(response);
    }

    public static ResponseEntity<ApiResponse<Void>> error(HttpStatus status, String message) {
        ApiResponse<Void> response = new ApiResponse<>(false, status, message, null);
        return ResponseEntity.status(status).body(response);
    }

    public boolean isSuccess() {
        return success;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
