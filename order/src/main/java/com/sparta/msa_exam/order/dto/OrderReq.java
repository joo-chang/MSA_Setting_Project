package com.sparta.msa_exam.order.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderReq {
    private String name;
    private List<Long> productIds;
}
