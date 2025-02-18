package com.amalitech.lab_2_ecommerce.service;

import com.amalitech.lab_2_ecommerce.entity.OrderEntity;
import com.amalitech.lab_2_ecommerce.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderEntity placeOrder(OrderEntity orderEntity) {
        return orderRepository.save(orderEntity);
    }
    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }
}
