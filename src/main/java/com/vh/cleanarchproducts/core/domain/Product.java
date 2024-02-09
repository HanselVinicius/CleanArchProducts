package com.vh.cleanarchproducts.core.domain;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Builder
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product implements Serializable {

    @Setter
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private Long serialNumber;
    @Setter
    private ProductStatusEnum productStatusEnum;
    @Setter
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

}
