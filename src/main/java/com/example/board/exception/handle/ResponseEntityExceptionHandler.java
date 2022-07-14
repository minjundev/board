package com.example.board.exception.handle;

import com.example.board.exception.ResourceNotFoundException;
import com.example.board.exception.domain.ResponseError;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public ResponseError handleResourceNotFound(ResourceNotFoundException e) {
        ResponseError responseError = new ResponseError(404, "Resource is not exist.");
        return responseError;
    }
}
