package com.vh.cleanarchproducts.entrypoint.consumer;

import com.vh.cleanarchproducts.core.usecase.product.BuyProductConfirmationUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ProductConsumer {


    @Autowired
    public BuyProductConfirmationUseCase buyProductConfirmationUseCase;

    @KafkaListener(topics = "buy-product",groupId = "product-guys-group")
    public void consume(@Payload String message){
        this.buyProductConfirmationUseCase.confirmBuy(message);
    }
}
