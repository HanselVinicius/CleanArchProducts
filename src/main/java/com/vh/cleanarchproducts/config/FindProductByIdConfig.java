package com.vh.cleanarchproducts.config;

import com.vh.cleanarchproducts.core.usecase.product.FindProductByIdUseCase;
import com.vh.cleanarchproducts.core.usecase.product.impl.FindProductByIdImpl;
import com.vh.cleanarchproducts.dataprovider.impl.FindProductByIdProviderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindProductByIdConfig {

    @Bean
    public FindProductByIdUseCase findProductByIdUseCase(FindProductByIdProviderImpl findProductByIdProvider) {
        return new FindProductByIdImpl(findProductByIdProvider);
    }
}
