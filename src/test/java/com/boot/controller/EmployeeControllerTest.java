package com.boot.controller;

import com.boot.entity.employee.Department;
import com.boot.entity.employee.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup(){
        EmployeeController employeeController = new EmployeeController();
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    private String jsonString(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }

    @Test
    public void testEmployeeInfo() throws Exception {
        Employee emp = new Employee(1, "abc", List.of(new Department(1, "Finance")));

        ResultActions response = mockMvc.perform(post("/api/v1/employee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString(emp)));

        response.andDo(print())
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.empId").value(emp.getId()))
                .andExpect(jsonPath("$.message").value("Received Employee Data"));
    }
}
