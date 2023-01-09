package com.example.productmanagement.controllers;

import com.example.productmanagement.dto.ProductRequest;
import com.example.productmanagement.dto.ProductResponse;
import com.example.productmanagement.entities.Product;
import com.example.productmanagement.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/saveProduct")
    public Product saveProduct(@RequestBody ProductRequest product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/userProduct/{id}")
    public List<ProductResponse> getAllProduct(@PathVariable Integer id) {
        return productService.getAllProduct(id);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable Long productId) {
        return new ResponseEntity<>(productService.getProductById(productId), HttpStatus.OK);
    }

    @DeleteMapping("/deleteProduct/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long productId) {
        return new ResponseEntity<>(productService.deleteProduct(productId), HttpStatus.OK);
    }

    @PutMapping("/updateProduct/{productId}")
    public ResponseEntity<?> editProduct( @PathVariable Long productId,@RequestBody Product product) {
        return new ResponseEntity<>(productService.editProduct(productId, product), HttpStatus.CREATED);
    }
}
