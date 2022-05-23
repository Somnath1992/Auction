package com.fse.product.cmd.infrastructure;

import com.fse.cqrs.core.domain.AggregateRoot;
import com.fse.cqrs.core.handlers.EventSourcingHandler;
import com.fse.cqrs.core.infrastructure.EventStore;
import com.fse.product.cmd.domain.ProductAggregate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
public class ProductTrxnEventSourcingHandler implements EventSourcingHandler<ProductAggregate> {
    @Autowired
    private EventStore eventStore;


    @Override
    public void save(AggregateRoot aggregate) {
        eventStore.saveEvents(aggregate.getId(), aggregate.getUncommittedChanges(), aggregate.getVersion());
        aggregate.markChangesAsCommitted();
    }


}
