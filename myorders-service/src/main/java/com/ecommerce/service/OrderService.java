package com.ecommerce.service;

import com.ecommerce.client.ProductClient;
import com.ecommerce.client.UserClient;
import com.ecommerce.entity.Orders;
import com.ecommerce.dto.Product;
import com.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private UserClient userClient;

    @Autowired
    private ProductClient productClient;

    @Autowired
    private OrderRepository repository;

    public Orders createOrder(Orders order) {

        // Call User Service
        // validate user
        userClient.getUserById(order.getUserId());

        // Call Product Service
        // get product
        Product product = productClient.getProductById(order.getProductId());

        // calculate total
        order.setTotalPrice(product.getPrice() * order.getQuantity());

        return repository.save(order);
    }
}
