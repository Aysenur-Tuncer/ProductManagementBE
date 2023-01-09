package com.example.productmanagement.dto;

import lombok.Data;

@Data
public class ProductRequest {

    String productName;
    Double price;
    Integer stock;
    Integer id;
}
