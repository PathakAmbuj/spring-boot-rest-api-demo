package com.boot.controller;

import com.boot.entity.employee.Employee;
import com.boot.feedback.AcknowledgementReceipt;
import com.boot.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @PostMapping(value = "/employee", consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<AcknowledgementReceipt> employeeInfo(@RequestBody Employee employeeInfo){

        List<Integer> deptIdList = new ArrayList<>();
                employeeInfo.getDepartment().forEach(e -> deptIdList.add(e.getDeptId()));

        AcknowledgementReceipt acknowledgementReceipt = AcknowledgementReceipt.builder()
                .empId(employeeInfo.getId())
                .deptId(deptIdList)
                .build();
        CommonUtil.printJson(employeeInfo);
        return new ResponseEntity<>(acknowledgementReceipt, HttpStatus.ACCEPTED);
    }
}
