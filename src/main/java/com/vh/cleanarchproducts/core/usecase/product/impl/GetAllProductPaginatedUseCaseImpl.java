package com.vh.cleanarchproducts.core.usecase.product.impl;

import com.vh.cleanarchproducts.core.dataprovider.GetAllProductPaginatedProvider;
import com.vh.cleanarchproducts.core.domain.Product;
import com.vh.cleanarchproducts.core.usecase.product.GetAllProductPaginatedUseCase;

import java.util.List;

public class GetAllProductPaginatedUseCaseImpl implements GetAllProductPaginatedUseCase {

    private final GetAllProductPaginatedProvider getAllProductPaginatedProvider;

    public GetAllProductPaginatedUseCaseImpl(GetAllProductPaginatedProvider getAllProductPaginatedProvider) {
        this.getAllProductPaginatedProvider = getAllProductPaginatedProvider;
    }

    @Override
    public List<Product> getAllPaginated(int page, int size) {
        return this.getAllProductPaginatedProvider.getAllPaginated(page, size);
    }
}
