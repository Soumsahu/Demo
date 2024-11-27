package com.cg.service;

import com.cg.entity.Order;
import java.util.List;
import java.util.Optional;

public interface IOrderService {

    Order createOrder(Order order);

    Optional<Order> findOrderById(int id);

    Order updateOrder(int id, Order order);

 
    void deleteOrder(int id);

    List<Order> findAllOrders();
}
