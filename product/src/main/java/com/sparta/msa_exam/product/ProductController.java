package com.sparta.msa_exam.product;

import com.sparta.msa_exam.product.dto.ProductDto;
import com.sparta.msa_exam.product.dto.ProductReq;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductReq productReq) {
        return ResponseEntity.ok(productService.createProduct(productReq));
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }
}
