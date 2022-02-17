package com.example.springbootapp.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestApiResponse {
    private int status;
    private String message;
    private Object data;

    public RestApiResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
