package com.vh.cleanarchproducts.core.usecase.product.impl;

import com.vh.cleanarchproducts.core.dataprovider.BuyProductConfirmationProvider;
import com.vh.cleanarchproducts.core.domain.ProductStatusEnum;
import com.vh.cleanarchproducts.core.usecase.product.BuyProductConfirmationUseCase;
import com.vh.cleanarchproducts.core.usecase.product.FindProductByIdUseCase;

public class BuyProductConfirmationImpl implements BuyProductConfirmationUseCase {

    private final BuyProductConfirmationProvider buyProductConfirmationProvider;

    private final FindProductByIdUseCase findProductByIdUseCase;

    public BuyProductConfirmationImpl(BuyProductConfirmationProvider buyProductConfirmationProvider, FindProductByIdUseCase findProductByIdUseCase) {
        this.buyProductConfirmationProvider = buyProductConfirmationProvider;
        this.findProductByIdUseCase = findProductByIdUseCase;
    }

    @Override
    public void confirmBuy(String productId) {
        var product = findProductByIdUseCase.findProductById(productId);
        product.setId(productId);
        product.setProductStatusEnum(ProductStatusEnum.RESERVED);
        this.buyProductConfirmationProvider.confirmBuy(product);
    }
}
