package com.example.iprwc_app_backend.service;

import com.example.iprwc_app_backend.controller.vo.OrderItemForm;
import com.example.iprwc_app_backend.exception.NotFoundException;
import com.example.iprwc_app_backend.model.*;
import com.example.iprwc_app_backend.repository.OrderItemRepository;
import com.example.iprwc_app_backend.repository.OrderRepository;
import com.example.iprwc_app_backend.repository.ShopItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class OrderService {
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private OrderRepository orderRepository;

    public List<OrderItem> readMyOrder() {
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
        User me = (User)authentication.getPrincipal();

        Optional<Order> optionalOrder = orderRepository.findByUserAndStatus(me, OrderStatus.OPEN);
        final Order order;
        if(optionalOrder.isPresent()) {
            order = optionalOrder.get();
        } else {
            return Collections.<OrderItem>emptyList();
        }

        return orderItemRepository.findByOrder(order);
    }

    public void addItemToOrder(ShopItem product) {
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
        User me = (User)authentication.getPrincipal();

        Optional<Order> optionalOrder = orderRepository.findByUserAndStatus(me, OrderStatus.OPEN);
        final Order order;
        if(optionalOrder.isPresent()) {
            order = optionalOrder.get();
        } else {
            order = Order.builder()
                    .status(OrderStatus.OPEN)
                    .user(me)
                    .build();
            orderRepository.save(order);
        }

        if (orderItemRepository.existsByOrderAndShopItem(order, product)) {
            return;
        }

        OrderItem orderItem = OrderItem.builder()
                .order(order)
                .shopItem(product)
                .build();

        orderItemRepository.save(orderItem);
    }

    public void removeItemFromOrder(ShopItem product) {
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
        User me = (User)authentication.getPrincipal();

        Optional<Order> optionalOrder = orderRepository.findByUserAndStatus(me, OrderStatus.OPEN);
        Order order = optionalOrder.orElseThrow(() -> new NotFoundException("No order exists"));

        OrderItem orderItem = orderItemRepository.findByOrderAndShopItem(order, product)
                .orElseThrow(() -> new NotFoundException("Item not found in the order"));

        orderItemRepository.delete(orderItem);
    }

    public void confirmOrder() {
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
        User me = (User)authentication.getPrincipal();

        Optional<Order> optionalOrder = orderRepository.findByUserAndStatus(me, OrderStatus.OPEN);
        Order order = optionalOrder.orElseThrow(() -> new NotFoundException("No order exists"));

        order.setStatus(OrderStatus.CLOSED);
        orderRepository.save(order);
    }

}
