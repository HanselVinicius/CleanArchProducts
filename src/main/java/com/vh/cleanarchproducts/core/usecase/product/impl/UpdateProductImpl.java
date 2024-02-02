package com.vh.cleanarchproducts.core.usecase.product.impl;

import com.vh.cleanarchproducts.core.dataprovider.UpdateProductProvider;
import com.vh.cleanarchproducts.core.domain.Product;
import com.vh.cleanarchproducts.core.usecase.product.FindProductByIdUseCase;
import com.vh.cleanarchproducts.core.usecase.product.UpdateProductUseCase;

public class UpdateProductImpl implements UpdateProductUseCase {

    private UpdateProductProvider updateProductProvider;

    private FindProductByIdUseCase findProductByIdUseCase;

    public UpdateProductImpl(UpdateProductProvider updateProductProvider, FindProductByIdUseCase findProductByIdUseCase) {
        this.updateProductProvider = updateProductProvider;
        this.findProductByIdUseCase = findProductByIdUseCase;
    }

    @Override
    public Product updateProduct(String id,Product product) {
        this.findProductByIdUseCase.findProductById(id);
        product.setId(id);
        return  this.updateProductProvider.updateProduct(product);
    }
}
