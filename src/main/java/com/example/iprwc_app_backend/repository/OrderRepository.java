package com.example.iprwc_app_backend.repository;

import com.example.iprwc_app_backend.model.Order;
import com.example.iprwc_app_backend.model.OrderItem;
import com.example.iprwc_app_backend.model.OrderStatus;
import com.example.iprwc_app_backend.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
    Optional<Order> findByUserAndStatus(User user, OrderStatus status);

}
