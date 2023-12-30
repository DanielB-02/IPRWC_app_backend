package com.example.iprwc_app_backend.service;

import com.example.iprwc_app_backend.controller.vo.AddProductRequest;
import com.example.iprwc_app_backend.model.ShopItem;
import com.example.iprwc_app_backend.repository.ShopItemRepository;
import com.example.iprwc_app_backend.security.AdminSecurity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ShopItemRepository shopItemRepository;

    @AdminSecurity
    public ShopItem addProduct(AddProductRequest request) {
        ShopItem shopItem = ShopItem.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .imageUrl(request.getImageUrl())
                .build();
        return shopItemRepository.save(shopItem);
    }
}
