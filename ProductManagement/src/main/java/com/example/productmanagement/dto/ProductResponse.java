package com.example.productmanagement.dto;

import com.example.productmanagement.entities.Product;
import lombok.Data;

@Data
public class ProductResponse {
    Long productId;
    Integer id;
    String productName;
    Double price;
    Integer stock;

    public ProductResponse(Product entity){
        this.productId=entity.getProductId();
        this.id=entity.getUser().getId();
        this.productName=entity.getProductName();
        this.price=entity.getPrice();
        this.stock=entity.getStock();
    }
}