package com.vh.cleanarchproducts.dataprovider.impl;

import com.vh.cleanarchproducts.core.dataprovider.BuyProductProvider;
import com.vh.cleanarchproducts.core.domain.Product;
import com.vh.cleanarchproducts.dataprovider.repository.mapper.message.ProductMessageProviderMapper;
import com.vh.cleanarchproducts.entrypoint.consumer.ProductMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class BuyProductProviderImpl implements BuyProductProvider {

    @Autowired
    public KafkaTemplate<String, ProductMessage> kafkaTemplate;

    @Autowired
    public ProductMessageProviderMapper productMessageMapper;

    private static final String TOPIC = "buy-product";

    @Override
    @CacheEvict(value = "product", allEntries = true)
    public void sendBuyProductMessage(Product product) {
        var message = productMessageMapper.toProductMessage(product);
        this.kafkaTemplate.send(TOPIC,message);

    }
}
