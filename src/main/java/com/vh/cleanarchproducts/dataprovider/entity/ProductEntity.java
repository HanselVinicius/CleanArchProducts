package com.vh.cleanarchproducts.dataprovider.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Table(name = "products_tbl")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {

    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private Long serialNumber;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ProductStatusEntityEnum statusEntityEnum;
    private boolean isActive;



    public ProductEntity(String id, String name, String description, BigDecimal price, Long serialNumber) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.serialNumber = serialNumber;
        this.statusEntityEnum = ProductStatusEntityEnum.AVAILABLE;
        this.isActive = true;
    }


}
