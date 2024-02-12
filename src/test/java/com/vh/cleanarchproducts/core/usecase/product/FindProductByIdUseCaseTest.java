package com.vh.cleanarchproducts.core.usecase.product;

import com.vh.cleanarchproducts.core.dataprovider.FindProductByIdProvider;
import com.vh.cleanarchproducts.core.domain.Product;
import com.vh.cleanarchproducts.core.usecase.product.impl.FindProductByIdImpl;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindProductByIdUseCaseTest {

    @InjectMocks
    private FindProductByIdImpl findProductById;

    @Mock
    private FindProductByIdProvider findProductByIdProvider;

    @Mock
    private Product product;

    @Test
    public void shouldReturnProductWhenProductExists() {
        //Arrange
        when(findProductByIdProvider.findProductById("id")).thenReturn(Optional.of(product));
        //Act
        var result = findProductById.findProductById("id");
        //Assert
        assertThat(result).isEqualTo(product);
    }

    @Test
    public void shouldThrowResourceNotFoundExceptionWhenProductNotExists() {
        //Arrange + act + assert
        Assertions.assertThrows(ResourceNotFoundException.class,()-> findProductById.findProductById("not-existent-id"));
    }

}