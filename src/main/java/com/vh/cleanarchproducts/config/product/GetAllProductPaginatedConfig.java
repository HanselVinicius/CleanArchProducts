package com.vh.cleanarchproducts.config.product;

import com.vh.cleanarchproducts.core.dataprovider.GetAllProductPaginatedProvider;
import com.vh.cleanarchproducts.core.usecase.product.GetAllProductPaginatedUseCase;
import com.vh.cleanarchproducts.core.usecase.product.impl.GetAllProductPaginatedImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GetAllProductPaginatedConfig {

    @Bean
    public GetAllProductPaginatedUseCase getAllProductPaginatedUseCase(GetAllProductPaginatedProvider getAllProductPaginatedProvider){
        return new GetAllProductPaginatedImpl(getAllProductPaginatedProvider);
    }

}
