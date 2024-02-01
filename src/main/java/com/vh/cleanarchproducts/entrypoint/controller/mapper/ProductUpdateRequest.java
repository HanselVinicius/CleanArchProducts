package com.vh.cleanarchproducts.entrypoint.controller.mapper;

import com.vh.cleanarchproducts.entrypoint.controller.transfer.ProductStatusTransfer;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductUpdateRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String description;
    private BigDecimal price;
    private Long stock;
    private ProductStatusTransfer status;
}
