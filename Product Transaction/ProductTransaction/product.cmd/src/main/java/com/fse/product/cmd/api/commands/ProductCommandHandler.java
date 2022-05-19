package com.fse.product.cmd.api.commands;

import com.fse.cqrs.core.handlers.EventSourcingHandler;
import com.fse.product.cmd.domain.ProductAggregate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCommandHandler implements CommandHandler {
    @Autowired
    private EventSourcingHandler<ProductAggregate> eventSourcingHandler;

    @Override
    public void handle(Transaction command) {
        var aggregate = new ProductAggregate(command);
        eventSourcingHandler.save(aggregate);
    }

}
