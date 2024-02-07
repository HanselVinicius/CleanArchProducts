package com.vh.cleanarchproducts.core.usecase.product;

import com.vh.cleanarchproducts.core.domain.Product;

import java.util.List;

public interface GetAllProductPaginatedUseCase {

    List<Product> getAllPaginated(int page, int size);
}
