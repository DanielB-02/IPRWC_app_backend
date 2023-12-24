package com.example.iprwc_app_backend.controller.vo;

import com.example.iprwc_app_backend.model.Order;
import com.example.iprwc_app_backend.model.ShopItem;

public class OrderItemForm {
    public Long id;
    public ShopItem shopItem;
    public Order order;
}
