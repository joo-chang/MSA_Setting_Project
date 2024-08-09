package com.sparta.msa_exam.order.dto;

import lombok.Data;

@Data
public class OrderReq {
    private Long order_id;
    private Long name;
    private Long count;
}
