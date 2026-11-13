
package com.jobportal.common.response;

public record ApiResponse<T>(
        boolean success,
        int code,
        String message,
        T data
) {

    public static <T> ApiResponse<T> success(
            String message, T data) {
        return new ApiResponse<>(true, 200, message, data);
    }

    public static <T> ApiResponse<T> created(
            String message, T data) {
        return new ApiResponse<>(true, 201, message, data);
    }

    public static <T> ApiResponse<T> error(
            int code, String message, T data) {
        return new ApiResponse<>(false, code, message, data);
    }
}
