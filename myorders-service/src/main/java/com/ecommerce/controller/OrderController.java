package com.ecommerce.controller;

import com.ecommerce.entity.Orders;
import com.ecommerce.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping
    public Orders createOrder(@RequestBody Orders order) {
        return service.createOrder(order);
    }
}