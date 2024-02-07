package com.vh.cleanarchproducts.config;

import com.vh.cleanarchproducts.core.usecase.validations.BuyValidation;
import com.vh.cleanarchproducts.core.usecase.validations.isProductAvailableValidation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BuyValidationConfig {

    @Bean
    public List<BuyValidation> buyValidations(){
        return List.of(new isProductAvailableValidation());
    }
}
