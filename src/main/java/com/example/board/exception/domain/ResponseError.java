package com.example.board.exception.domain;

import lombok.Data;

@Data
public class ResponseError {

    private int code;
    private String message;

    public ResponseError(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
