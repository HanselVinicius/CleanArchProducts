package com.vh.cleanarchproducts.core.domain;

import lombok.*;

import java.math.BigDecimal;

@Builder
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {

    @Setter
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private Long stock;
    private ProductStatusEnum productStatusEnum;


    public Product( String name, String description, BigDecimal price, Long stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.productStatusEnum = ProductStatusEnum.AVAILABLE;
    }


    public Product(String name, String description, BigDecimal price, Long stock, ProductStatusEnum productStatusEnum) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.productStatusEnum = productStatusEnum;
    }
}
