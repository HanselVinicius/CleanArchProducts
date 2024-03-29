package com.vh.cleanarchproducts.entrypoint.controller.mapper;

import com.vh.cleanarchproducts.core.domain.Product;
import com.vh.cleanarchproducts.core.domain.ProductStatusEnum;
import com.vh.cleanarchproducts.entrypoint.controller.transfer.ProductStatusTransfer;
import com.vh.cleanarchproducts.entrypoint.controller.transfer.request.ProductInsertRequest;
import com.vh.cleanarchproducts.entrypoint.controller.transfer.request.ProductUpdateRequest;
import com.vh.cleanarchproducts.entrypoint.controller.transfer.response.ProductResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductMapperImpl implements ProductMapper {
    @Override
    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getSerialNumber(),
                toProductStatusTransfer(product.getProductStatusEnum()
                )
        );
    }

    @Override
    public Product productInsertRequestToProduct(ProductInsertRequest productRequest) {
        return new Product(
                productRequest.getName(),
                productRequest.getDescription(),
                productRequest.getPrice(),
                productRequest.getSerialNumber()
        );
    }

    @Override
    public Product productUpdateRequestToProduct(ProductUpdateRequest productRequest) {
        return new Product(
                productRequest.getName(),
                productRequest.getDescription(),
                productRequest.getPrice(),
                productRequest.getSerialNumber(),
                toProductStatusEnum(productRequest.getStatus()),
                true
        );
    }

    @Override
    public List<ProductResponse> toProductResponseList(List<Product> products) {
        return products.stream().map(this::toProductResponse).toList();
    }

    private ProductStatusEnum toProductStatusEnum(ProductStatusTransfer status) {
        return ProductStatusEnum.valueOf(status.name());
    }

    public ProductStatusTransfer toProductStatusTransfer(ProductStatusEnum productStatusEnum) {
        return ProductStatusTransfer.valueOf(productStatusEnum.name());
    }
}
