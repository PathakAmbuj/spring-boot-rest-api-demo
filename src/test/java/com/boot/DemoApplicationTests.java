package com.boot;

import com.boot.controller.EmployeeControllerTest;
import com.boot.controller.ProductController;
import com.boot.controller.ProductControllerTest;
import com.boot.controller.TestProductController;
import com.boot.service.ProductServiceTest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@RunWith(Suite.class)
@Suite.SuiteClasses({
		ProductServiceTest.class,
		EmployeeControllerTest.class,
		ProductControllerTest.class,
		TestProductController.class
})
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

}
