package com.vh.cleanarchproducts.config.exception;

import com.vh.cleanarchproducts.core.domain.ProductNotAvailableException;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.kafka.common.errors.ProducerFencedException;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Exceptions {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiException> notFound(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        ApiException err = new ApiException(
                error,
                e.getMessage()
        );
        return ResponseEntity.status(status).body(err);
    }


    @ExceptionHandler(ProductNotAvailableException.class)
    public ResponseEntity<ApiException> notAvailable(ProductNotAvailableException e, HttpServletRequest request) {
        String error = e.getMessage();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ApiException err = new ApiException(
                error,
                e.getMessage()
        );
        return ResponseEntity.status(status).body(err);
    }


}
