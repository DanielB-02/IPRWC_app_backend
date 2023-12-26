package com.example.iprwc_app_backend.repository;

import com.example.iprwc_app_backend.model.Order;
import com.example.iprwc_app_backend.model.OrderItem;
import com.example.iprwc_app_backend.model.ShopItem;
import com.example.iprwc_app_backend.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {
    boolean existsByOrderAndShopItem(Order order, ShopItem shopItem);
    Optional<OrderItem> findByOrderAndShopItem(Order order, ShopItem shopItem);
    List<OrderItem> findByOrder(Order order);
}
