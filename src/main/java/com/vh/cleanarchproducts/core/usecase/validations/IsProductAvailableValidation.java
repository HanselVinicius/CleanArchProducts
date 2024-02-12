package com.vh.cleanarchproducts.core.usecase.validations;

import com.vh.cleanarchproducts.core.domain.Product;
import com.vh.cleanarchproducts.core.domain.ProductStatusEnum;

public class IsProductAvailableValidation implements BuyValidation {
    @Override
    public boolean isValid(Product product) {
        return product.getProductStatusEnum() == ProductStatusEnum.AVAILABLE;
    }
}
