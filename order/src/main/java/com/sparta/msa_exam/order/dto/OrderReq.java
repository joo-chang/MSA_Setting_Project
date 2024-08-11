package com.sparta.msa_exam.order.dto;

import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderReq {
    private String name;
    private List<Long> productIds;
}
