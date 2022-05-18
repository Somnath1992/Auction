package com.fse.product.cmd.api.commands;

import com.fse.cqrs.core.commands.BaseCommand;
import com.fse.product.common.dto.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProductCommand extends BaseCommand {


    private Integer productId;
    private String productName;
    private String shortDescription;
    private String description;
    private String category;
    private BigDecimal startingPrice;
    private Timestamp bidEndDate;
}
