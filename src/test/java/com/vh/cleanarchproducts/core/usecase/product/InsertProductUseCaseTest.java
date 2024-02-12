package com.vh.cleanarchproducts.core.usecase.product;

import com.vh.cleanarchproducts.core.dataprovider.InsertProductProvider;
import com.vh.cleanarchproducts.core.domain.Product;
import com.vh.cleanarchproducts.core.usecase.product.impl.InsertProductImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class InsertProductUseCaseTest {


    @InjectMocks
    private InsertProductImpl insertProductImpl;

    @Mock
    private InsertProductProvider insertProductProvider;


    @Mock
    private Product product;


    @Test
    public void shouldInsertProduct(){
        //Arrange
        when(insertProductProvider.insertProduct(product)).thenReturn(product);
        //Act
        var result = this.insertProductImpl.insertProduct(product);
        //Assert
        assertEquals(result, product);
    }

}