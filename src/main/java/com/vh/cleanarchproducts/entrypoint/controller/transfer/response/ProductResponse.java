package com.vh.cleanarchproducts.entrypoint.controller.transfer.response;

import com.vh.cleanarchproducts.entrypoint.controller.transfer.ProductStatusTransfer;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ProductResponse {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private Long serialNumber;
    private ProductStatusTransfer productStatusTransfer;
}
