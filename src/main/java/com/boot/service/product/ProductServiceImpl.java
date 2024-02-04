package com.boot.service.product;

import com.boot.entity.product.Product;
import com.boot.repository.product.ProductRepository;
import com.boot.service.CrudService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service("ProductServiceImpl")
@Slf4j
@AllArgsConstructor
public class ProductServiceImpl implements CrudService<Product> {
    @Autowired
    private final ProductRepository productRepository;

    public ResponseEntity<Product> save(Product product) {
        Product newProduct = productRepository.save(product);
        return ResponseEntity.ok(newProduct);
    }

    // Get all products
    public ResponseEntity<List<Product>> fetchAll() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    // Get a product by ID
    public ResponseEntity<Optional<Product>> fetchById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.of(Optional.of(product));
            // return ResponseEntity.notFound().build();
        }
    }

    //  update a single product from the database
    public ResponseEntity<Product> update(Long id, Product updatedProduct) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        Product Existingproduct = productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
        Existingproduct.setName(updatedProduct.getName());
        Existingproduct.setPrice(updatedProduct.getPrice());
        Existingproduct.setQuantity(updatedProduct.getQuantity());
        Product savedEntity = productRepository.save(Existingproduct);
        return ResponseEntity.ok(savedEntity);
    }

    // delete a single product
    public ResponseEntity<String> delete(Long id) {
        productRepository.deleteById(id);
        return ResponseEntity.ok("Product Deleted Successfully");
    }


}
