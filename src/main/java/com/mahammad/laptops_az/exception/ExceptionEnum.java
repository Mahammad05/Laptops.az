package com.mahammad.laptops_az.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ExceptionEnum {

    // AUTH EXCEPTIONS
    USER_NOT_FOUND_EXCEPTION(HttpStatus.BAD_REQUEST, "User not found!"),
    DUPLICATE_EMAIL_OR_USERNAME_EXCEPTION(HttpStatus.BAD_REQUEST, "Username or Email already exists!"),
    WRONG_PASSWORD_OR_USERNAME_EXCEPTION(HttpStatus.BAD_REQUEST, "Username or Password is wrong!"),
    TOKEN_INVALID_EXCEPTION(HttpStatus.BAD_REQUEST, "Token is invalid!"),
    TOKEN_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "Token not found!"),
    UNAUTHORIZED_EXCEPTION(HttpStatus.UNAUTHORIZED, "Unauthorized Access!"),

    // PRODUCT EXCEPTIONS
    PRODUCT_NOT_FOUND_EXCEPTION(HttpStatus.BAD_REQUEST, "Product not found!"),
    CATEGORY_NOT_FOUND_EXCEPTION(HttpStatus.BAD_REQUEST, "Category not found!"),
    BRAND_NOT_FOUND_EXCEPTION(HttpStatus.BAD_REQUEST, "Brand not found!"),

    // STOCK, BALANCE, ORDER EXCEPTIONS
    STOCK_NOT_FOUND_EXCEPTION(HttpStatus.BAD_REQUEST, "Stock not found!"),
    BALANCE_NOT_ENOUGH_EXCEPTION(HttpStatus.BAD_REQUEST, "Your balance is not enough!"),
    STOCK_STATUS_IS_FALSE_EXCEPTION(HttpStatus.BAD_REQUEST, "Stock buyStatus is false. You can't sell it!"),

    // MESSAGE EXCEPTIONS
    MESSAGE_NOT_SEND_EXCEPTION(HttpStatus.BAD_GATEWAY, "Error occurred while sending mail!");

    private final HttpStatus status;
    private final String message;

}
