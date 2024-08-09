package com.sparta.msa_exam.product.dto;

import com.sparta.msa_exam.product.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    private Long product_id;
    private String name;
    private Integer supply_price;

    public static ProductDto toDto(Product product) {
        return ProductDto.builder()
                .product_id(product.getProduct_id())
                .name(product.getName())
                .supply_price(product.getSupply_price())
                .build();
    }
}
