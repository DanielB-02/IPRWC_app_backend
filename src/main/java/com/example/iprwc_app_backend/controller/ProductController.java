package com.example.iprwc_app_backend.controller;

import com.example.iprwc_app_backend.controller.vo.AddProductRequest;
import com.example.iprwc_app_backend.controller.vo.ShopItemResult;
import com.example.iprwc_app_backend.security.AdminSecurity;
import com.example.iprwc_app_backend.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ShopItemResult addProduct(@RequestBody @Valid AddProductRequest request) {
        return ShopItemResult.create(productService.addProduct(request));
    }
}
