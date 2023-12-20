package com.example.iprwc_app_backend.service;

import com.example.iprwc_app_backend.controller.vo.ShopItemForm;
import com.example.iprwc_app_backend.exception.NotFoundException;
import com.example.iprwc_app_backend.model.ShopItem;
import com.example.iprwc_app_backend.repository.ShopItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ShopItemService {
    @Autowired
    private ShopItemRepository shopItemRepository;

    public ShopItem create(ShopItemForm form){
        return saveShopItem(form, new ShopItem());
    }

    private ShopItem saveShopItem(ShopItemForm form, ShopItem entityToSave) {
        entityToSave.setName(form.name);
        entityToSave.setDescription(form.description);
        entityToSave.setPrice(form.price);
        entityToSave.setImageUrl(form.imageUrl);
        return this.shopItemRepository.save(entityToSave);
    }

    public Iterable<ShopItem> readAll() {
        return shopItemRepository.findAll();
    }

    public Optional<ShopItem> readSingle(long id) {
        return this.shopItemRepository.findById(id);
    }


    public ShopItem update(Long id, ShopItemForm form){
        Optional<ShopItem> fetchedShopItem = shopItemRepository.findById(id);
        if(fetchedShopItem.isEmpty()){
            throw new NotFoundException("Shop Item with id: " + id + " not found");
        }
        return saveShopItem(form, fetchedShopItem.get());
    }

    public void delete(Long id){
        if (!shopItemRepository.existsById(id)) {
            throw new NotFoundException("Shop Item with id: " + id + " not found");
        }
        shopItemRepository.deleteById(id);
    }

}
