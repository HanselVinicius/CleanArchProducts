package com.vh.cleanarchproducts.core.dataprovider;

import com.vh.cleanarchproducts.core.domain.Product;

import java.util.List;

public interface GetAllProductPaginatedProvider {

    List<Product> getAllPaginated(int page, int size);

}
