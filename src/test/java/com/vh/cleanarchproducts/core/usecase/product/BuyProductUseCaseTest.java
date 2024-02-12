package com.vh.cleanarchproducts.core.usecase.product;

import com.vh.cleanarchproducts.core.dataprovider.BuyProductProvider;
import com.vh.cleanarchproducts.core.domain.Product;
import com.vh.cleanarchproducts.core.domain.ProductStatusEnum;
import com.vh.cleanarchproducts.core.usecase.product.impl.BuyProductImpl;
import com.vh.cleanarchproducts.core.usecase.validations.BuyValidation;
import com.vh.cleanarchproducts.core.usecase.validations.IsProductAvailableValidation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class BuyProductUseCaseTest {


    @Mock
    private BuyProductProvider buyProductProvider;
    @Mock
    private FindProductByIdUseCase findProductById;
    @InjectMocks
    private BuyProductImpl buyProduct;

    private Product product;
    @Mock
    private List<BuyValidation> buyValidation = new ArrayList<>();

    @Test
    public void shouldBuyProductWhenAvaiable(){
        //Arrange
        String productId = "id";
        this.product = new Product(productId, "name", "description", BigDecimal.TEN, 10L, ProductStatusEnum.AVAILABLE, true);
        Mockito.when(findProductById.findProductById(productId)).thenReturn(product);

        //Act
        this.buyProduct.buyProduct(productId);

        //Assert
        then(findProductById).should().findProductById(productId);
        then(buyProductProvider).should().sendBuyProductMessage(product);
    }


}