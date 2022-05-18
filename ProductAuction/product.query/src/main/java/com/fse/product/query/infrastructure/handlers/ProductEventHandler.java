package com.fse.product.query.infrastructure.handlers;


import com.fse.product.common.dto.ProductCategory;
import com.fse.product.common.events.ProductOpenedEvent;
import com.fse.product.query.domain.Product;
import com.fse.product.query.domain.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductEventHandler implements EventHandler {
    @Autowired
    private ProductRepository productRepository;


    @Override
    public void on(ProductOpenedEvent event) {
        ProductCategory cat = ProductCategory.valueOf(event.getCategory().toUpperCase());
        var bankAccount = Product.builder()
                .productId(event.getProductId())
                .productName(event.getProductName())
                .category(cat.getDisplayName())
                .shortDescription(event.getShortDescription())
                .startingPrice(event.getStartingPrice())
                .bidEndDate(event.getBidEndDate())
                .description(event.getDescription())
                .build();
        productRepository.save(bankAccount);
    }
}
