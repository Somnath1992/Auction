package com.fse.product.cmd.infrastructure;

import com.fse.cqrs.core.events.BaseEvent;
import com.fse.cqrs.core.events.EventModel;
import com.fse.cqrs.core.infrastructure.EventStore;

import com.fse.cqrs.core.producers.EventProducer;
import com.fse.product.cmd.domain.EventStoreRepository;
import com.fse.product.cmd.domain.ProductAggregate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductEventStore implements EventStore {
    @Autowired
    private EventProducer eventProducer;

    @Autowired
    private EventStoreRepository eventStoreRepository;


    @Override
    public void saveEvents(String aggregateId, Iterable<BaseEvent> events, int expectedVersion) {
       var eventStream = eventStoreRepository.findByAggregateIdentifier(aggregateId);

        if (expectedVersion != -1 && eventStream.get(eventStream.size() - 1).getVersion() != expectedVersion) {
            throw new RuntimeException("expected version is -1");
        }
        var version = expectedVersion;
        for (var event: events) {
            version++;
            event.setVersion(version);
            var eventModel = EventModel.builder()
                    .timeStamp(new Date())
                    .aggregateIdentifier(aggregateId)
                    .aggregateType(ProductAggregate.class.getTypeName())
                    .version(version)
                    .eventType(event.getClass().getTypeName())
                    .eventData(event)
                    .build();
            var persistedEvent = eventStoreRepository.save(eventModel);
            if (persistedEvent.getId()!=null) {
                eventProducer.produce(event.getClass().getSimpleName(), event);
            }
        }
    }
}
