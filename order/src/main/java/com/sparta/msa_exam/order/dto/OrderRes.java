package com.sparta.msa_exam.order.dto;

import com.sparta.msa_exam.order.client.ProductResponseDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class OrderRes {
    private Long orderId;
    private String name;
    private List<Long> products;
}
