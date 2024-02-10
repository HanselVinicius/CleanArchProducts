package com.vh.cleanarchproducts.entrypoint.consumer;

import com.vh.cleanarchproducts.core.domain.ProductStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductMessage {

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

}
