package com.vh.cleanarchproducts.dataprovider.impl;

import com.vh.cleanarchproducts.core.dataprovider.FindProductByIdProvider;
import com.vh.cleanarchproducts.core.domain.Product;
import com.vh.cleanarchproducts.dataprovider.repository.ProductEntityRepository;
import com.vh.cleanarchproducts.dataprovider.repository.mapper.ProductEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindProductByIdProviderImpl implements FindProductByIdProvider {


    @Autowired
    private ProductEntityRepository productRepository;

    @Autowired
    private ProductEntityMapper productMapper;

    @Override
    public Optional<Product> findProductById(String id) {
        var product = productRepository.findProductByIdAndIsActiveTrue(id);
        return product.map(productMapper::toProduct);
    }
}
