package com.boot.entity.employee;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @JsonProperty("deptId")
    private int deptId;

    @JsonProperty("deptName")
    private String deptName;
}
