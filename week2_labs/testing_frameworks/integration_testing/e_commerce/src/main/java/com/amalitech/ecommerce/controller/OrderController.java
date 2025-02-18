package com.amalitech.lab_2_ecommerce.controller;

import com.amalitech.lab_2_ecommerce.entity.OrderEntity;
import com.amalitech.lab_2_ecommerce.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public String showOrders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "orders";
    }

    @PostMapping("/place/order")
    public String placeOrder(@ModelAttribute("order") OrderEntity order) {
        System.out.println(order.getProducts().get(0).getName());
        orderService.placeOrder(order);
        return "redirect:/orders";
    }
}
