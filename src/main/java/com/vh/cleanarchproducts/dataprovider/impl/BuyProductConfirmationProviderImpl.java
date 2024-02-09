package com.vh.cleanarchproducts.dataprovider.impl;

import com.vh.cleanarchproducts.core.dataprovider.BuyProductConfirmationProvider;
import com.vh.cleanarchproducts.core.domain.Product;
import com.vh.cleanarchproducts.dataprovider.repository.ProductEntityRepository;
import com.vh.cleanarchproducts.dataprovider.repository.mapper.ProductEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;

@Component
public class BuyProductConfirmationProviderImpl implements BuyProductConfirmationProvider {
    @Autowired
    private ProductEntityRepository productEntityRepository;
    @Autowired
    private ProductEntityMapper productEntityMapper;
    @Override
    @CacheEvict(value = "product", allEntries = true)
    public void confirmBuy(Product product) {
        this.productEntityRepository.save(productEntityMapper.toProductUpdateEntity(product));
    }
}
