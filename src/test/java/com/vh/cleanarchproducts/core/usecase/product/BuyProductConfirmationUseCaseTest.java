package com.vh.cleanarchproducts.core.usecase.product;

import com.vh.cleanarchproducts.core.dataprovider.BuyProductConfirmationProvider;
import com.vh.cleanarchproducts.core.domain.Product;
import com.vh.cleanarchproducts.core.domain.ProductStatusEnum;
import com.vh.cleanarchproducts.core.usecase.product.impl.BuyProductConfirmationImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class BuyProductConfirmationUseCaseTest {

    @InjectMocks
    private BuyProductConfirmationImpl buyProductConfirmationUseCase;

    @Mock
    private BuyProductConfirmationProvider buyProductConfirmationProvider;

    @Mock
    private Product product;


    @Test
    public void shouldConfirmBuy() {
        //Arrange
        product = new Product();
        //Act
        buyProductConfirmationUseCase.confirmBuy(product);
        //Assert
        then(buyProductConfirmationProvider).should().confirmBuy(product);
        assertEquals(ProductStatusEnum.RESERVED, product.getProductStatusEnum());
    }

}