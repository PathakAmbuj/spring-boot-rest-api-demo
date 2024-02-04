package com.boot.service;

import com.boot.entity.product.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CrudService<T> {

    ResponseEntity<T> save(T saveObject);

    ResponseEntity<List<T>> fetchAll();

    ResponseEntity<Optional<T>> fetchById(Long id);

    ResponseEntity<T> update(Long id, T updateObject);

    ResponseEntity<String> delete(Long id);
}
