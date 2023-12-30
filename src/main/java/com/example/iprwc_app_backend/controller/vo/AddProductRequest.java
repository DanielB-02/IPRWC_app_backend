package com.example.iprwc_app_backend.controller.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddProductRequest {
    public String name;
    public String description;
    public double price;
    public String imageUrl;

}
