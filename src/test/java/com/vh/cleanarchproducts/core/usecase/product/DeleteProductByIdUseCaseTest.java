package com.vh.cleanarchproducts.core.usecase.product;

import com.vh.cleanarchproducts.core.dataprovider.DeleteProductByIdProvider;
import com.vh.cleanarchproducts.core.domain.Product;
import com.vh.cleanarchproducts.core.usecase.product.impl.DeleteProductByIdImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
class DeleteProductByIdUseCaseTest {


    @Mock
    private FindProductByIdUseCase findProductByIdUseCase;

    @Mock
    private DeleteProductByIdProvider deleteProductProvider;

    @InjectMocks
    private DeleteProductByIdImpl deleteProductByIdUseCase;

    @Mock
    private Product product;

    @Test
    public void shouldDeleteProductById() {
        //Arrange
        given(findProductByIdUseCase.findProductById("id")).willReturn(product);
        //Act
        this.deleteProductByIdUseCase.deleteProductById("id");
        //Assert
        assertThat(product.isActive()).isFalse();


    }


}