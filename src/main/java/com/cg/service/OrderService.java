package com.cg.service;

import com.cg.entity.Order;
import com.cg.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Optional<Order> findOrderById(int id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order updateOrder(int id, Order order) {
        // Find the order by id first
        Order existingOrder = orderRepository.findById(id).orElse(null);

        // If the order exists, update it; if not, return null or handle as needed
        if (existingOrder != null) {
            existingOrder.setOrderDate(order.getOrderDate());
            existingOrder.setOrderNo(order.getOrderNo());
            return orderRepository.save(existingOrder); // Save the updated order
        } else {
            return null; // Or you can return a default object or handle it differently
        }
    }

    @Override
    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }
}
