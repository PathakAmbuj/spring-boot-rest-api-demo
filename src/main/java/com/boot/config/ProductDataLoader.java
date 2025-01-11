package com.boot.config;

import com.boot.entity.product.Product;
import com.boot.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ProductDataLoader {
    @Autowired
    private final ProductRepository repo;

    public ProductDataLoader(ProductRepository repo) {
        this.repo = repo;
    }

    @EventListener
    public void appReady(ApplicationReadyEvent event) {

        repo.save(new Product("mobile", 12000, 1));
    }
}
