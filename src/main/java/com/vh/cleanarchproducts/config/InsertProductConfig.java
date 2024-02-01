package com.vh.cleanarchproducts.config;

import com.vh.cleanarchproducts.core.dataprovider.InsertProductProvider;
import com.vh.cleanarchproducts.core.usecase.product.InsertProductUseCase;
import com.vh.cleanarchproducts.core.usecase.product.impl.InsertProductImpl;
import com.vh.cleanarchproducts.dataprovider.impl.InsertProductProviderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertProductConfig {


    @Bean
    public InsertProductUseCase insertProductUseCase(InsertProductProviderImpl insertProductImpl) {
        return new InsertProductImpl(insertProductImpl);
    }

}
