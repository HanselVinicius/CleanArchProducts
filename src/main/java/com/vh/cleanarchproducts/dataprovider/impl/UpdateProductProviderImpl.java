package com.vh.cleanarchproducts.dataprovider.impl;

import com.vh.cleanarchproducts.core.dataprovider.UpdateProductProvider;
import com.vh.cleanarchproducts.core.domain.Product;
import com.vh.cleanarchproducts.dataprovider.repository.ProductEntityRepository;
import com.vh.cleanarchproducts.dataprovider.repository.mapper.ProductEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;

@Component
public class UpdateProductProviderImpl implements UpdateProductProvider {

    @Autowired
    private ProductEntityRepository productEntityRepository;

    @Autowired
    private ProductEntityMapper productEntityMapper;
    @Override
    @CacheEvict(value = "product", allEntries = true)
    public Product updateProduct(Product product) {
        var productEntity = productEntityMapper.toProductUpdateEntity(product);
        return productEntityMapper.toProduct(this.productEntityRepository.save(productEntity));

    }
}
