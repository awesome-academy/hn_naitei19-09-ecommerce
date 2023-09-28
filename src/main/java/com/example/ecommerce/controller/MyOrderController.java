package com.example.ecommerce.controller;

import com.example.ecommerce.model.Order;
import com.example.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class MyOrderController {

        Long userID = 2L;  // Refactor later
        Long cancelStatusID = 5L;
        @Autowired
        private OrderService orderService;
        @RequestMapping("/my-orders")
        public String showMyOrders(Model map) {
            List<Order> orders = orderService.findByUserId(userID);
            map.addAttribute("orders" , orders);
            return "user/orders/index";
        }
        @GetMapping("/my-orders/{code}")
        public String getOrderDetail(Model model, @PathVariable("code") String code) {
            Order order = orderService.findOrderByOrderCode(code);
            model.addAttribute("orderDetails", order.getOrderDetails());
            model.addAttribute("orderTotal", order.getTotal());
            model.addAttribute("status", order.getStatus().getDescription().getStatus());
            return "user/orders/detail/index";
        }
        @PostMapping("/cancel-order/{orderCode}")
        public String cancelOrder(@PathVariable("orderCode") String orderCode, @RequestParam("reason") String reason, Model model) {
            Order order = orderService.findOrderByOrderCode(orderCode);
            orderService.updateOrderStatus(order.getId(),cancelStatusID,reason);
            return "redirect:/my-orders";
        }
}
