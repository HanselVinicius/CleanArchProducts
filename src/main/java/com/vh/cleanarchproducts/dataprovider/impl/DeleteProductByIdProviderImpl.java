package com.vh.cleanarchproducts.dataprovider.impl;

import com.vh.cleanarchproducts.core.dataprovider.DeleteProductByIdProvider;
import com.vh.cleanarchproducts.core.domain.Product;
import com.vh.cleanarchproducts.dataprovider.entity.ProductEntity;
import com.vh.cleanarchproducts.dataprovider.repository.ProductEntityRepository;
import com.vh.cleanarchproducts.dataprovider.repository.mapper.ProductEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteProductByIdProviderImpl implements DeleteProductByIdProvider {

    @Autowired
    private ProductEntityRepository productEntityRepository;

    @Autowired
    private ProductEntityMapper productEntityMapper;
    @Override
    public void deleteProductById(Product product) {
        ProductEntity productEntity = this.productEntityMapper.toProductDeleteEntity(product);
        this.productEntityRepository.save(productEntity);
    }
}
