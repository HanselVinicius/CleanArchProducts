package com.vh.cleanarchproducts.entrypoint.controller.transfer.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductInsertRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String description;
    private BigDecimal price;
    private Long stock;


}
