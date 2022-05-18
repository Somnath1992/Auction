package com.fse.product.query.infrastructure.handlers;

import com.fse.product.common.events.ProductOpenedEvent;


public interface EventHandler {
    void on(ProductOpenedEvent event);

}
