package com.mahammad.laptops_az.exception;

import lombok.Getter;

@Getter
public class ApplicationException extends RuntimeException {

    private final ExceptionEnum exceptionEnum;

    public ApplicationException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.exceptionEnum = exceptionEnum;
    }

}
