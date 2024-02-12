package com.vh.cleanarchproducts.core.usecase.product;

import com.vh.cleanarchproducts.core.dataprovider.UpdateProductProvider;
import com.vh.cleanarchproducts.core.domain.Product;
import com.vh.cleanarchproducts.core.usecase.product.impl.UpdateProductImpl;
import com.vh.cleanarchproducts.dataprovider.impl.UpdateProductProviderImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateProductUseCaseTest {

    @InjectMocks
    private UpdateProductImpl updateProductUseCase;

    @Mock
    private Product product;

    @Mock
    private UpdateProductProvider updateProductProvider;

    @Mock
    private FindProductByIdUseCase findProductByIdUseCase;

    @Test
    public void shouldReturnUpdatedProduct() {
        //Arrange
        when(this.updateProductProvider.updateProduct(product)).thenReturn(product);
        //Act
        var result = this.updateProductUseCase.updateProduct("id", product);
        //Assert
        assertEquals(result, product);
    }


}