package com.vh.cleanarchproducts.dataprovider.impl;

import com.vh.cleanarchproducts.core.dataprovider.GetAllProductPaginatedProvider;
import com.vh.cleanarchproducts.core.domain.Product;
import com.vh.cleanarchproducts.dataprovider.repository.ProductEntityRepository;
import com.vh.cleanarchproducts.dataprovider.repository.mapper.ProductEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllProductPaginatedProviderImpl implements GetAllProductPaginatedProvider {

    @Autowired
    private ProductEntityRepository productRepository;

    @Autowired
    private ProductEntityMapper productEntityMapper;

    @Override
    @Cacheable(value = "product", key = "'allProducts'")
    public List<Product> getAllPaginated(int page, int size) {
        var productEntityPage = productRepository.findAllByIsActiveTrue(PageRequest.of(page, size));
        return this.productEntityMapper.toProductList(productEntityPage.getContent());
    }
}
