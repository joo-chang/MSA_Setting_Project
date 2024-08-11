package com.sparta.msa_exam.order;

import com.sparta.msa_exam.order.dto.OrderReq;
import com.sparta.msa_exam.order.dto.OrderRes;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @Value("${server.port}")
    private String serverPort;

    private <T>ResponseEntity<T> responseEntity(T body, HttpStatus status) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Server-Port", serverPort);
        return new ResponseEntity<>(body, headers, status);
    }

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody OrderReq orderReq) {
        orderService.createOrder(orderReq);
        return responseEntity(null, HttpStatus.OK);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<Void> updateOrder(@PathVariable("orderId") Long orderId, @RequestParam("productId") Long productId) {
        orderService.updateOrder(orderId, productId);
        return responseEntity(null, HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderRes> getOrders(@PathVariable("orderId") Long orderId) {
        return responseEntity(orderService.getOrders(orderId), HttpStatus.OK);
    }
}
