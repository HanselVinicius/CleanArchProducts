package com.vh.cleanarchproducts.dataprovider.impl;

import com.vh.cleanarchproducts.core.dataprovider.InsertProductProvider;
import com.vh.cleanarchproducts.core.domain.Product;
import com.vh.cleanarchproducts.dataprovider.entity.ProductEntity;
import com.vh.cleanarchproducts.dataprovider.repository.ProductEntityRepository;
import com.vh.cleanarchproducts.dataprovider.repository.mapper.ProductEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;

@Component
public class InsertProductProviderImpl implements InsertProductProvider {

    @Autowired
    private ProductEntityRepository productRepository;

    @Autowired
    private ProductEntityMapper productEntityMapper;

    @Override
    @CacheEvict(value = "product", allEntries = true)
    public Product insertProduct(Product product) {
        ProductEntity insertedProduct = productRepository.save(productEntityMapper.toProductInsertEntity(product));
        return productEntityMapper.toProduct(insertedProduct);
    }
}
