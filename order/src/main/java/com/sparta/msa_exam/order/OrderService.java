package com.sparta.msa_exam.order;

import com.sparta.msa_exam.order.client.ProductClient;
import com.sparta.msa_exam.order.client.ProductResponseDto;
import com.sparta.msa_exam.order.dto.OrderReq;
import com.sparta.msa_exam.order.dto.OrderRes;
import com.sparta.msa_exam.order.entity.Order;
import com.sparta.msa_exam.order.entity.OrderProduct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductClient productClient;

    @Transactional
    public void createOrder(OrderReq orderReq) {
        Order order = Order.builder()
                .name(orderReq.getName())
                .build();
        List<ProductResponseDto> products = productClient.getProducts();
        List<Long> productIds = products.stream().map(ProductResponseDto::getProductId).toList();
        for (Long productId : orderReq.getProductIds()) {
            if(!productIds.contains(productId)) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
            }
            OrderProduct orderProduct = OrderProduct.builder()
                    .productId(productId)
                    .build();
            order.addProduct(orderProduct);
        }
        orderRepository.save(order);
    }

    @Transactional
    public void updateOrder(Long orderId, Long productId) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        order.getProductIds().add(OrderProduct.builder().productId(productId).build());
        orderRepository.save(order);
    }

    public OrderRes getOrders(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow();

        return OrderRes.builder()
                .orderId(order.getOrderId())
                .name(order.getName())
                .products(order.getProductIds().stream().map(OrderProduct::getProductId).toList())
                .build();
    }
}
