package com.vh.cleanarchproducts.config.product;

import com.vh.cleanarchproducts.core.dataprovider.BuyProductProvider;
import com.vh.cleanarchproducts.core.usecase.product.BuyProductUseCase;
import com.vh.cleanarchproducts.core.usecase.product.FindProductByIdUseCase;
import com.vh.cleanarchproducts.core.usecase.product.impl.BuyProductImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuyProductConfig {

    @Bean
    public BuyProductUseCase buyProductUseCase(FindProductByIdUseCase findProductByIdUseCase, BuyProductProvider buyProductProvider){
        return new BuyProductImpl(findProductByIdUseCase,buyProductProvider);
    }

}
