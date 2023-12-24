package com.example.iprwc_app_backend.controller;

import com.example.iprwc_app_backend.controller.vo.ShopItemForm;
import com.example.iprwc_app_backend.model.ShopItem;
import com.example.iprwc_app_backend.service.ShopItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/shop-item")
public class ShopItemController {
    @Autowired
    private ShopItemService shopItemService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ShopItem create(@RequestBody @Valid ShopItemForm form){
        return this.shopItemService.create(form);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ShopItem update(@PathVariable long id, @RequestBody @Valid ShopItemForm form){
        return this.shopItemService.update(id, form);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id){
        shopItemService.delete(id);
    }

}
