package com.example.iprwc_app_backend.controller.vo;

import com.example.iprwc_app_backend.model.ShopItem;

public class ShopItemResult {
    public Long id;
    public String name;
    public String description;
    public double price;
    public String imageUrl;

    public static ShopItemResult create(ShopItem shopItem) {
        ShopItemResult result = new ShopItemResult();

        result.id = shopItem.getId();
        result.name = shopItem.getName();
        result.description = shopItem.getDescription();
        result.price = shopItem.getPrice();
        result.imageUrl = shopItem.getImageUrl();
        return result;
    }
}
