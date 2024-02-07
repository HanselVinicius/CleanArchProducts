package com.vh.cleanarchproducts.config.product;

import com.vh.cleanarchproducts.core.dataprovider.UpdateProductProvider;
import com.vh.cleanarchproducts.core.usecase.product.FindProductByIdUseCase;
import com.vh.cleanarchproducts.core.usecase.product.UpdateProductUseCase;
import com.vh.cleanarchproducts.core.usecase.product.impl.UpdateProductImpl;
import com.vh.cleanarchproducts.dataprovider.impl.UpdateProductProviderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateProductConfig {


    @Bean
    public UpdateProductUseCase updateProductUseCase(UpdateProductProvider updateProductProvider, FindProductByIdUseCase findProductByIdUseCase){
        return new UpdateProductImpl(updateProductProvider,findProductByIdUseCase);
    }

}
