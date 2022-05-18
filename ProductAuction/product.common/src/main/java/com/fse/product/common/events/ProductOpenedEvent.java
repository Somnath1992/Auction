package com.fse.product.common.events;


import com.fse.cqrs.core.events.BaseEvent;
import com.fse.product.common.dto.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ProductOpenedEvent extends BaseEvent {
    private Integer productId;
    private String productName;
    private String shortDescription;
    private String description;
    private String category;
    private BigDecimal startingPrice;
    private Timestamp bidEndDate;
}
