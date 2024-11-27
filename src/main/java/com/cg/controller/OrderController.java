package com.cg.controller;


import com.cg.entity.Order;
import com.cg.exception.ResourceNotFound;
import com.cg.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    IOrderService orderService;

    @PostMapping("/create")
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }
    @Value("${app.name}")
	private String appName;
	@GetMapping(path = "/getorderbyid/{id}")
    public String getProductById(@PathVariable int id) {
        Optional<Order> order = orderService.findOrderById(id);
 
        if (order.isPresent()) {
            return order.get().toString();  
        } else {
            System.out.println(appName);
            return appName;
        }
    }

    @PutMapping("/update")
    public Order updateOrder(@RequestBody Order order) {
       return orderService.updateOrder(order.getOrderId(), order);

    }
    @DeleteMapping("/deletebyid/{id}")
    public void deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
    }

    @GetMapping("/getallorders")
    public List<Order> getAllOrders() {
        return orderService.findAllOrders()
                            .stream()
                            .collect(Collectors.toList());
    }
}
