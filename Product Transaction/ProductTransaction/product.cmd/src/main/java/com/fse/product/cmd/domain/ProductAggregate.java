package com.fse.product.cmd.domain;

import com.fse.cqrs.core.domain.AggregateRoot;
import com.fse.product.cmd.api.commands.Transaction;
import com.fse.product.common.dto.ProductCategory;
import com.fse.product.common.events.ProductOpenedEvent;

import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
public class ProductAggregate extends AggregateRoot {
    private Boolean active;
    private double balance;

    public double getBalance() {
        return this.balance;
    }

    public ProductAggregate(Transaction command) {

        boolean futureOrNot = getFutureOrNot(command.getBidEndDate());
        ProductCategory cat = ProductCategory.valueOf(command.getCategory());
        if(futureOrNot) {
            raiseEvent(ProductOpenedEvent.builder()
                    .productId(command.getProductId())
                    .productName(command.getProductName())
                    .category(cat.getDisplayName())
                    .shortDescription(command.getShortDescription())
                    .startingPrice(command.getStartingPrice())
                    .bidEndDate(command.getBidEndDate())
                    .description(command.getDescription())
                    .build());
        }
    }

    private static boolean getFutureOrNot(Timestamp ts)
    {
        if(ts.after(new Timestamp(System.currentTimeMillis())))
            return true;
        else
            return false;
    }
   /* public void apply(ProductOpenedEvent event) {
        this.id = event.getId();
        this.active = true;
       // this. = event.getCategory();
    }*/


}
