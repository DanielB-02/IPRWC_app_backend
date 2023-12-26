package com.example.iprwc_app_backend.controller;

import com.example.iprwc_app_backend.controller.vo.OrderItemForm;
import com.example.iprwc_app_backend.controller.vo.OrderItemResult;
import com.example.iprwc_app_backend.controller.vo.ShopItemForm;
import com.example.iprwc_app_backend.model.OrderItem;
import com.example.iprwc_app_backend.model.ShopItem;
import com.example.iprwc_app_backend.service.OrderService;
import com.example.iprwc_app_backend.service.ShopItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<OrderItemResult> readMyOrder(){
        return this.orderService.readMyOrder().stream()
                .map(orderItem -> {
                    OrderItemResult orderItemResult = new OrderItemResult();
                    orderItemResult.amount = 1; // TO DO dit moet nog afgemaakt worden!
                    orderItemResult.shopItem = orderItem.getShopItem();
                    return orderItemResult;
                })
                .toList();
    }

    @RequestMapping(value = "/product/{product}", method = RequestMethod.POST)
    public void addItemToOrder(@PathVariable ShopItem product){
        this.orderService.addItemToOrder(product);
    }

    @RequestMapping(value = "/product/{product}", method = RequestMethod.DELETE)
    public void removeItemFromOrder(@PathVariable ShopItem product){
        this.orderService.removeItemFromOrder(product);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public void confirmOrder(){
        this.orderService.confirmOrder();
    }

}
