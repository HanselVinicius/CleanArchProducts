package com.vh.cleanarchproducts.config.product;

import com.vh.cleanarchproducts.core.dataprovider.BuyProductConfirmationProvider;
import com.vh.cleanarchproducts.core.usecase.product.BuyProductConfirmationUseCase;
import com.vh.cleanarchproducts.core.usecase.product.FindProductByIdUseCase;
import com.vh.cleanarchproducts.core.usecase.product.impl.BuyProductConfirmationImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuyProductConfirmationConfig {


    @Bean
    public BuyProductConfirmationUseCase buyProductConfirmationUseCase(BuyProductConfirmationProvider buyProductConfirmationProvider, FindProductByIdUseCase findProductByIdUseCase){
        return new BuyProductConfirmationImpl(buyProductConfirmationProvider, findProductByIdUseCase);
    }
}
