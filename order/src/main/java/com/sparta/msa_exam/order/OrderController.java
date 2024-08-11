package com.sparta.msa_exam.order;

import com.sparta.msa_exam.order.dto.OrderReq;
import com.sparta.msa_exam.order.dto.OrderRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody OrderReq orderReq) {
        orderService.createOrder(orderReq);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<Void> updateOrder(@PathVariable("orderId") Long orderId, @RequestBody Long productId) {
        orderService.updateOrder(orderId, productId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderRes> getOrders(@PathVariable("orderId") Long orderId) {
        return ResponseEntity.ok(orderService.getOrders(orderId));

    }
}
