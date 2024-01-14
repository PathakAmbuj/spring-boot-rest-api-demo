package com.boot.data;

import com.boot.entity.Product;
import com.boot.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class DataLoader implements ApplicationRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Product p1 = new Product("Samsung", 45679, 2);
        Product p2 = new Product("Apple", 72000, 1);
        try {
            productRepository.save(p1);
            productRepository.save(p2);
            log.info("Record Inserted : " + p1.toString());
            log.info("Record Inserted : " + p2.toString());
        } catch (Exception e) {
            log.warn("Data preload failed : " + e.getMessage());
        }
    }
}