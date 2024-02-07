package com.vh.cleanarchproducts.dataprovider.impl;

import com.vh.cleanarchproducts.core.dataprovider.BuyProductProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class BuyProductProviderImpl implements BuyProductProvider {

    @Autowired
    public KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendBuyProductMessage(String productId) {
        this.kafkaTemplate.send("buy-product",productId);

    }
}
