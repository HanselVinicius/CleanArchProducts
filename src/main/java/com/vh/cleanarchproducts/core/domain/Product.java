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
    private Long serialNumber;
    private ProductStatusEnum productStatusEnum;
    private boolean isActive;


    public Product( String name, String description, BigDecimal price, Long serialNumber) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.serialNumber = serialNumber;
        this.productStatusEnum = ProductStatusEnum.AVAILABLE;
        this.isActive = true;
    }


    public Product(String name, String description, BigDecimal price, Long serialNumber, ProductStatusEnum productStatusEnum,boolean isActive) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.serialNumber = serialNumber;
        this.productStatusEnum = productStatusEnum;
        this.isActive = isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
