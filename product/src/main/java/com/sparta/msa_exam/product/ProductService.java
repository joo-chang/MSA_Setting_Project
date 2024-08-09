package com.sparta.msa_exam.product;

import com.sparta.msa_exam.product.dto.ProductDto;
import com.sparta.msa_exam.product.dto.ProductReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public String createProduct(ProductReq productReq) {
        Product product = Product.builder()
                .name(productReq.getName())
                .supply_price(productReq.getSupply_price())
                .build();
        productRepository.save(product);
        return "상품이 등록되었습니다.";
    }

    public List<ProductDto> getProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(ProductDto::toDto)
                .collect(Collectors.toList());
    }
}
