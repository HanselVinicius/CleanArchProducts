package com.vh.cleanarchproducts.core.usecase.validations;

import com.vh.cleanarchproducts.core.domain.Product;

public interface BuyValidation {

    boolean isValid(Product product);
}
