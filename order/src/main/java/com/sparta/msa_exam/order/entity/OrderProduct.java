package com.sparta.msa_exam.order.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "order_product")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderProduct {
    @Id
    private Long id;
    private Long productId;
    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

}
