package com.boot.service;

import com.boot.entity.product.Product;
import com.boot.repository.product.ProductRepository;
import com.boot.service.product.ProductServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductServiceImpl productService;
    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void saveProductTest(){
        Product product = new Product("Apple", 1234567.0, 1);
        productService.save(product);
        verify(productRepository).save(product);
    }

    @Test
    public void fetchAllProductsTest(){

    }
}
