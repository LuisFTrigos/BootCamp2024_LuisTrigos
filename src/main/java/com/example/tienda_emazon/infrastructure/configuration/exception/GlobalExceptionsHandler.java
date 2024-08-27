package com.example.tienda_emazon.infrastructure.configuration.exception;

import com.example.tienda_emazon.domain.exception.BrandAlreadyExistsException;
import com.example.tienda_emazon.domain.exception.CategoryAlreadyExistsException;
import com.example.tienda_emazon.application.dto.response.ErrorResponse;
import com.example.tienda_emazon.domain.exception.InvalidDescriptionException;
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
    public ErrorResponse handlerInvalidDescription(InvalidDescriptionException ex) {
        return new ErrorResponse("Descripción invalida" , ex.getMessage());
    }

    @ExceptionHandler(BrandAlreadyExistsException.class)
    @ResponseStatus
    @ResponseBody
    public ErrorResponse handlerBrandAlreadyExistException(BrandAlreadyExistsException brandAlreadyExistsException){
        return new ErrorResponse("Marca ya existente", brandAlreadyExistsException.getMessage());
    }

}
