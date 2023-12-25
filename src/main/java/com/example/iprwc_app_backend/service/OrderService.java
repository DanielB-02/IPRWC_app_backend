package com.example.iprwc_app_backend.service;

import com.example.iprwc_app_backend.controller.vo.OrderItemForm;
import com.example.iprwc_app_backend.exception.NotFoundException;
import com.example.iprwc_app_backend.model.Order;
import com.example.iprwc_app_backend.model.OrderItem;
import com.example.iprwc_app_backend.model.ShopItem;
import com.example.iprwc_app_backend.model.User;
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

import java.util.Optional;

@Component
public class OrderService {
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private OrderRepository orderRepository;

    public Iterable<OrderItem> readMyOrder() {
        return null;
    }

    public void addItemToOrder(ShopItem product) {
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken)SecurityContextHolder.getContext().getAuthentication();
        User me = (User)authentication.getPrincipal();

        Optional<Order> optionalOrder = orderRepository.findByUser(me);
        final Order order;
        if(optionalOrder.isPresent()) {
            order = optionalOrder.get();
        } else {
            order = Order.builder()
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

    public void removeItemFromOrder(ShopItem product){
        Order order = Order.builder().build();
        if (order == null) {
            return;
        }

        OrderItem orderItem = orderItemRepository.findByOrderAndShopItem(order, product)
                .orElseThrow(() -> new NotFoundException("Item not found in the order"));

        orderItemRepository.delete(orderItem);
    }

    public Iterable<OrderItem> confirmOrder() {
        // TO DO - Implement me!
        return null;
    }


}
