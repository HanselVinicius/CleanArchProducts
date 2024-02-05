package com.vh.cleanarchproducts.config;

import com.vh.cleanarchproducts.core.dataprovider.DeleteProductByIdProvider;
import com.vh.cleanarchproducts.core.usecase.product.DeleteProductByIdUseCase;
import com.vh.cleanarchproducts.core.usecase.product.FindProductByIdUseCase;
import com.vh.cleanarchproducts.core.usecase.product.impl.DeleteProductByIdImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteProductByIdConfig {

    @Bean
    public DeleteProductByIdUseCase deleteProductByIdUseCase(FindProductByIdUseCase findProductByIdUseCase, DeleteProductByIdProvider deleteProductByIdProvider) {
        return new DeleteProductByIdImpl(findProductByIdUseCase,deleteProductByIdProvider);
    }

}
