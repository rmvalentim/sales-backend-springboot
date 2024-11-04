package br.com.rafaelvalentim.Sales.controllers;

import br.com.rafaelvalentim.Sales.dtos.OrderCreateDto;
import br.com.rafaelvalentim.Sales.entities.Order;
import br.com.rafaelvalentim.Sales.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping("/orders")
@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    
    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Order> createOrder(@RequestBody OrderCreateDto orderCreateDto) {
        return ResponseEntity.ok(orderService.createOrder(orderCreateDto));
    }
}
