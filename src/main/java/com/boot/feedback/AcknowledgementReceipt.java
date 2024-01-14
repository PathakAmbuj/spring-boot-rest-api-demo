package com.boot.feedback;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class AcknowledgementReceipt {

    @JsonProperty("empId")
    private int empId;

    @JsonProperty("deptId")
    private List<Integer> deptId;

    @JsonProperty("message")
    @Builder.Default
    private String message = "Received Employee Data";
}