package com.swp391.admin.model.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public List<Order> getListOrder() {
        return orderRepository.findAll();
    }

    public void createOrder(Order order) {
        order.setTotalPrice(0);
        orderRepository.save(order);
    }

    public Order getOrderById(int orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    public double getRevenue() {
        return orderRepository.getRevenue();
    }
}
