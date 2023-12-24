package com.example.iprwc_app_backend.service;

import com.example.iprwc_app_backend.controller.vo.OrderItemForm;
import com.example.iprwc_app_backend.exception.NotFoundException;
import com.example.iprwc_app_backend.model.OrderItem;
import com.example.iprwc_app_backend.model.ShopItem;
import com.example.iprwc_app_backend.repository.OrderItemRepository;
import com.example.iprwc_app_backend.repository.ShopItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    public Iterable<OrderItem> readMyOrder() {
        // TO DO - Implement me!
        return null;
    }

    public void removeItemFromOrder(ShopItem product){
        // TO DO - Implement me!
    }

    public Iterable<OrderItem> confirmOrder() {
        // TO DO - Implement me!
        return null;
    }

    public void addItemToOrder(ShopItem product) {
        // TO DO - Implement me!
    }
}
