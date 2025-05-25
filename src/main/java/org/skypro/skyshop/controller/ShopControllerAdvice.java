package org.skypro.skyshop.controller;

import org.skypro.skyshop.model.error.ShopError;
import org.skypro.skyshop.model.exeptions.NoSuchProductException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ShopControllerAdvice {

    @ExceptionHandler(NoSuchProductException.class)
    public ResponseEntity<ShopError> noSuchProductException(NoSuchProductException e){
        ShopError shopError = new ShopError("NO_SUCH_PRODUCT_WITH_THIS_ID", "Продукт с таким id не найден");
        return new ResponseEntity<ShopError>(shopError, HttpStatus.NOT_FOUND);
    }
}
