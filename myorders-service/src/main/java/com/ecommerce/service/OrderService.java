package com.ecommerce.service;

import com.ecommerce.client.ProductClient;
import com.ecommerce.client.UserClient;
import com.ecommerce.dto.User;
import com.ecommerce.entity.Orders;
import com.ecommerce.dto.Product;
import com.ecommerce.exception.ProductNotFoundException;
import com.ecommerce.exception.UserNotFoundException;
import com.ecommerce.repository.OrderRepository;
import feign.FeignException;
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
        try {
            userClient.getUserById(order.getUserId());
        } catch (FeignException.NotFound exception) {
            throw new UserNotFoundException("User not found with id " + order.getUserId());
        }

        // Call Product Service
        // get product
        Product product;
        try {
            product = productClient.getProductById(order.getProductId());
        } catch (FeignException.NotFound exception) {
            throw new ProductNotFoundException("Product not found with id " + order.getProductId());
        } catch (FeignException ex) {
            throw new RuntimeException("Product service is unavailable");
        }

        // calculate total
        order.setTotalPrice(product.getPrice() * order.getQuantity());

        return repository.save(order);
    }
}
