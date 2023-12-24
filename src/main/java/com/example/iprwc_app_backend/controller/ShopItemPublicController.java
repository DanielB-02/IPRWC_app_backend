package com.example.iprwc_app_backend.controller;

import com.example.iprwc_app_backend.controller.vo.ShopItemForm;
import com.example.iprwc_app_backend.model.ShopItem;
import com.example.iprwc_app_backend.service.ShopItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/public/shop-item")
public class ShopItemPublicController {
    @Autowired
    private ShopItemService shopItemService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<ShopItem> readAll(){
        return this.shopItemService.readAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<ShopItem> readSingle(@PathVariable long id){
        return this.shopItemService.readSingle(id);
    }
}
