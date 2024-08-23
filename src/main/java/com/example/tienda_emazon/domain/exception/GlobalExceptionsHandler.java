package com.example.tienda_emazon.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionsHandler {
    @ExceptionHandler(CategoryAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handlerCategoryAlreadyExistException(CategoryAlreadyExistsException
                                                                      categoryAlreadyExistsException) {
        return new ErrorResponse("Categoría ya existente" , categoryAlreadyExistsException.getMessage());
    }
    @ExceptionHandler(InvalidDescriptionException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handlerInvalidDescription(InvalidDescriptionException
                                                                      ex) {
        return new ErrorResponse("Descripciín invalida" , ex.getMessage());
    }

}
