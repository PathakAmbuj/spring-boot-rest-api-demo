package com.boot.service;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CrudService<T> {

    ResponseEntity<T> saveProduct(T product);

    ResponseEntity<List<T>> fetchAllProducts();

    ResponseEntity<Optional<T>> fetchProductById(Long id);
}
