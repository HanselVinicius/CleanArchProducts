package com.vh.cleanarchproducts.core.usecase.product;

import com.vh.cleanarchproducts.core.dataprovider.GetAllProductPaginatedProvider;
import com.vh.cleanarchproducts.core.domain.Product;
import com.vh.cleanarchproducts.core.usecase.product.impl.GetAllProductPaginatedImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class GetAllProductPaginatedUseCaseTest {


    @InjectMocks
    private GetAllProductPaginatedImpl getAllProductPaginatedUseCase;

    @Mock
    private List<Product> product;

    @Mock
    private GetAllProductPaginatedProvider getAllProductPaginatedProvider;

    @Test
    public void shouldReturnPaginatedProducts() {
        //Arrange
        when(this.getAllProductPaginatedProvider.getAllPaginated(1,10)).thenReturn(product);
        //Act
        var result = this.getAllProductPaginatedUseCase.getAllPaginated(1,10);
        //Assert
        assertEquals(result, product);
    }

}