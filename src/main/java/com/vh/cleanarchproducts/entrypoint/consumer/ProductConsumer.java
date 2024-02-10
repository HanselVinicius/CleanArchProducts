package com.vh.cleanarchproducts.entrypoint.consumer;

import com.vh.cleanarchproducts.core.usecase.product.BuyProductConfirmationUseCase;
import com.vh.cleanarchproducts.entrypoint.controller.mapper.message.ProductMessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ProductConsumer {

    @Autowired
    public BuyProductConfirmationUseCase buyProductConfirmationUseCase;

    @Autowired
    public ProductMessageMapper productMessageMapper;

    private static final String GROUP_ID = "product-guys-group";

    private static final String TOPIC = "buy-product";

    @KafkaListener(topics = TOPIC,groupId = GROUP_ID)
    public void consume(@Payload ProductMessage message){
        var productMessage = productMessageMapper.toProduct(message);
        this.buyProductConfirmationUseCase.confirmBuy(productMessage);
    }
}
