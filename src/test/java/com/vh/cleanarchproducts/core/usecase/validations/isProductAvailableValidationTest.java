package com.vh.cleanarchproducts.core.usecase.validations;

import com.vh.cleanarchproducts.core.domain.Product;
import com.vh.cleanarchproducts.core.domain.ProductStatusEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class isProductAvailableValidationTest {



    @Test
    public void shouldReturnTrueWhenProductIsAvailable() {
        //Arrange
        IsProductAvailableValidation isProductAvailableValidation = new IsProductAvailableValidation();
        Product product = new Product("id","name","deck", BigDecimal.ONE,1L, ProductStatusEnum.AVAILABLE,true);
        //Act
        boolean result = isProductAvailableValidation.isValid(product);
        //Assert
        Assertions.assertTrue(result);
    }

    @Test
    public void shouldReturnFalseWhenProductIsReserved() {
        //Arrange
        IsProductAvailableValidation isProductAvailableValidation = new IsProductAvailableValidation();
        Product product = new Product("id","name","deck", BigDecimal.ONE,1L, ProductStatusEnum.RESERVED,true);
        //Act
        boolean result = isProductAvailableValidation.isValid(product);
        //Assert
        Assertions.assertFalse(result);
    }


    @Test
    public void shouldReturnFalseWhenProductIsSold() {
        //Arrange
        IsProductAvailableValidation isProductAvailableValidation = new IsProductAvailableValidation();
        Product product = new Product("id","name","deck", BigDecimal.ONE,1L, ProductStatusEnum.SOLD,true);
        //Act
        boolean result = isProductAvailableValidation.isValid(product);
        //Assert
        Assertions.assertFalse(result);
    }





}