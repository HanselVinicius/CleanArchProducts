package com.vh.cleanarchproducts.entrypoint.controller.transfer.request;

import com.vh.cleanarchproducts.entrypoint.controller.transfer.ProductStatusTransfer;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductUpdateRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @DecimalMin(value = "10.0")
    private BigDecimal price;
    private Long serialNumber;
    private ProductStatusTransfer status;
}
