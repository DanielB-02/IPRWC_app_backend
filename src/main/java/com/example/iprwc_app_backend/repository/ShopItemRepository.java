package com.example.iprwc_app_backend.repository;

import com.example.iprwc_app_backend.model.ShopItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ShopItemRepository extends CrudRepository<ShopItem, Long> {
}
