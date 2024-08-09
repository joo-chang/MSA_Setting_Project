package com.sparta.msa_exam.order;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "order_product")
@Data
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Order order;
    private Long product_id;
}
