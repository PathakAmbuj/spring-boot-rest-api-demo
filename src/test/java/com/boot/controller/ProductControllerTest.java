package com.boot.controller;

import com.boot.entity.Product;
import com.boot.repository.ProductRepository;
import com.boot.service.CrudService;
import com.boot.service.ProductServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


//@AutoConfigureMockMvc
//@SpringBootTest
/*@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
@AutoConfigureMockMvc(addFilters = false)
@ActiveProfiles*/

@WebMvcTest
@RunWith(SpringRunner.class)
@Slf4j
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductController productController;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CrudService<Product> crudService;

   /* @InjectMocks
    private CommonUtil commonUtil;*/

    @MockBean
    @Qualifier("ProductServiceImpl")
    private ProductServiceImpl productService;

   /* @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }*/

   /* @Before
    public void setup() {
        *//*CommonUtil commonUtil = new CommonUtil();
        ProductServiceImpl productService = new ProductServiceImpl(productRepository);*//*
        ProductController productController = new ProductController();
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
        //MockitoAnnotations.openMocks(this);
    }*/

    private String jsonString(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }

    @Test
    public void testSaveProduct() throws Exception {
        Product product = new Product(5L, "Samsung", 45679, 2);
        ResponseEntity<Product> response = ResponseEntity.ok(product);
        when(productRepository.save(Mockito.any(Product.class))).thenAnswer(i -> i.getArguments()[0]);
        Mockito.when(productService.saveProduct(
                Mockito.any(Product.class))).thenReturn(response);
       // when(productService.saveProduct(product)).thenReturn(productRepository.save(product));
        //when(productRepository.save(Mockito.any(Product.class))).thenAnswer(product);


        RequestBuilder requestBuilder = MockMvcRequestBuilders.
                post("/api/v1/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonString(product));
        /*.andDo(print())
                .andExpect(status().isOk());*/

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result.getResponse().getContentAsString());
        log.info("response : "+result.getResponse().getContentAsString());

        MockHttpServletResponse res = result.getResponse();

        assertEquals(res.getStatus(), HttpStatus.OK.value());
        //verify(productController, atLeastOnce()).saveProduct(product);
                /*.andExpect(jsonPath("$.id", is(5)))
                .andExpect(jsonPath("$.name").value(product.getName()))
                .andExpect(jsonPath("$.price").value(product.getPrice()))
                .andExpect(jsonPath("$.quantity").value(product.getQuantity()));*/
    }

    @Test
    public void testGetAllProducts() throws Exception {
        List<Product> productList = List.of(
                new Product(1L, "Samsung", 45679, 2),
                new Product(2L, "Apple", 45679, 2),
                new Product(3L, "Google", 45679, 2));

        when(productService.fetchAllProducts()).thenReturn(ResponseEntity.ok(productList));

        ResultActions response = this.mockMvc.perform(get("/api/v1/products"));

        response.andExpect(status().isOk())
                //.andExpect(jsonPath("$.size()").value(productList.size()))
                .andDo(print());
    }
}
