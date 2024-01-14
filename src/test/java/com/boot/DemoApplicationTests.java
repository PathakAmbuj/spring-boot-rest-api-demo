package com.boot;

import com.boot.controller.ProductController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class DemoApplicationTests {

	@MockBean
	public ProductController productController;

	@Test
	void contextLoads() {
	}

}
