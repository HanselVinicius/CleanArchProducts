package com.vh.cleanarchproducts.core.usecase.product.impl;

import com.vh.cleanarchproducts.core.dataprovider.BuyProductProvider;
import com.vh.cleanarchproducts.core.domain.ProductNotAvailableException;
import com.vh.cleanarchproducts.core.usecase.product.BuyProductUseCase;
import com.vh.cleanarchproducts.core.usecase.product.FindProductByIdUseCase;
import com.vh.cleanarchproducts.core.usecase.validations.BuyValidation;

import java.util.List;

public class BuyProductImpl implements BuyProductUseCase {

    private FindProductByIdUseCase findProductByIdUseCase;
    private BuyProductProvider buyProductProvider;
    private List<BuyValidation> buyValidationList;

    public BuyProductImpl(FindProductByIdUseCase findProductByIdUseCase, BuyProductProvider buyProductProvider, List<BuyValidation> buyValidationList) {
        this.findProductByIdUseCase = findProductByIdUseCase;
        this.buyProductProvider = buyProductProvider;
        this.buyValidationList = buyValidationList;
    }

    @Override
    public void buyProduct(String productId) {
        var product = findProductByIdUseCase.findProductById(productId);
        buyValidationList.forEach(buyValidation -> {
            if(!buyValidation.isValid(product)){
                throw new ProductNotAvailableException("Product not available");
            }
        });
        this.buyProductProvider.sendBuyProductMessage(productId);
    }
}
