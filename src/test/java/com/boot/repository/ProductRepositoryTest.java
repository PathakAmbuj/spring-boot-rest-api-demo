package com.boot.repository;

import com.boot.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testSave(){
        Product p1 = new Product("Samsung", 45679, 2);

        Product insertedProduct = productRepository.save(p1);

        assertThat(entityManager.find(Product.class, insertedProduct.getId()) ).isEqualTo(p1);
        assertFalse(productRepository.findAll().isEmpty());
    }
}
