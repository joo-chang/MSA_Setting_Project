package com.sparta.msa_exam.order;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;
    private String name;

    @OneToMany(mappedBy = "order")
    private List<OrderProduct> product_ids;
}
