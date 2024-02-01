package com.vh.cleanarchproducts.entrypoint.controller.mapper;

import com.vh.cleanarchproducts.core.domain.Product;
import com.vh.cleanarchproducts.entrypoint.controller.transfer.request.ProductInsertRequest;
import com.vh.cleanarchproducts.entrypoint.controller.transfer.response.ProductResponse;

public interface ProductMapper {

    ProductResponse toProductResponse(Product product);

    Product productInsertRequestToProduct(ProductInsertRequest productRequest);

    Product productUpdateRequestToProduct(ProductUpdateRequest productRequest);

}
