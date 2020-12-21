package com.example.base;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Optional;

/**
 * @author: Jackson
 * @date: 2019/11/6
 * @description:
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @SuppressWarnings("unchecked")
    @ExceptionHandler({RuntimeException.class, Exception.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<ApiResponse> internalExceptionHandler(Exception e) {
        log.error("internalExceptionHandler: stacktrace", e);
        ApiResponse apiResponse = ApiResponse.respond(ApiResponseEnum.INTERNAL_ERROR);
        return new ResponseEntity(apiResponse, HttpStatus.OK);
    }


    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<ApiResponse> constraintExceptionHandler(ConstraintViolationException e) {
        Optional<ConstraintViolation<?>> optional = e.getConstraintViolations().stream().findFirst();
        String errorMsg = optional.isPresent() ? optional.get().getMessage() : "unknow error";
        return new ResponseEntity(ApiResponse.respond(ApiResponseEnum.BAD_REQUEST, errorMsg), HttpStatus.OK);
    }

    @ExceptionHandler({BizException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<ApiResponse> bizExceptionHandler(BizException bizException) {
        ApiBaseEnum apiBaseEnum = bizException.getApiEnum();
        String customMsg = bizException.getCustomMsg();
        log.error("intercept===BusinessException===info=={}", bizException.getMessage());
        if (apiBaseEnum != null && customMsg != null) {
            return new ResponseEntity(ApiResponse.respond(apiBaseEnum, customMsg), HttpStatus.OK);
        }
        if (customMsg != null) {
            return new ResponseEntity(ApiResponse.respond(customMsg), HttpStatus.OK);
        }
        if (apiBaseEnum != null) {
            return new ResponseEntity(ApiResponse.respond(apiBaseEnum), HttpStatus.OK);
        }
        return new ResponseEntity(ApiResponse.respond(ApiResponseEnum.INTERNAL_ERROR), HttpStatus.OK);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<ApiResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String errorMsg = e.getBindingResult()
                .getAllErrors()
                .get(0)
                .getDefaultMessage();
        return new ResponseEntity(ApiResponse.respond(ApiResponseEnum.INTERNAL_ERROR, errorMsg), HttpStatus.OK);
    }
}
