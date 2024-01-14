package com.boot.controller;

import com.boot.entity.Product;
import com.boot.service.CrudService;
import com.boot.service.ProductServiceImpl;
import com.boot.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    @Qualifier("ProductServiceImpl")
    private CrudService<Product> productService;

    public ProductController(ProductServiceImpl productServiceImpl) {
        this.productService = productServiceImpl;
    }

    // Create a new product
    @PostMapping(value = "/product", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        CommonUtil.printJson(productService.saveProduct(product));
        return  productService.saveProduct(product);
    }

    // Get all products
    @GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getAllProducts() {
        ResponseEntity<List<Product>> response = productService.fetchAllProducts();
        CommonUtil.printJson(response);
        return response;
    }

    // Get a product by ID
    @GetMapping(value = "/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable Long id) {
        CommonUtil.printJson(productService.fetchProductById(id));
        return productService.fetchProductById(id);
    }


}
