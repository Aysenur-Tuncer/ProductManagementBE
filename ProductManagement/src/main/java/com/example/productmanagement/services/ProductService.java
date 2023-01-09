package com.example.productmanagement.services;

import com.example.productmanagement.dto.ProductRequest;
import com.example.productmanagement.dto.ProductResponse;
import com.example.productmanagement.entities.Product;
import com.example.productmanagement.repos.ProductRepository;
import com.example.productmanagement.user.User;
import com.example.productmanagement.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;


    public Product saveProduct(ProductRequest product) {
        User user= userRepository.findById(product.getId()).orElse(null);
        Product toSave=new Product();
        toSave.setProductName(product.getProductName());
        toSave.setPrice(product.getPrice());
        toSave.setStock(product.getStock());
        toSave.setUser(user);
        return productRepository.save(toSave);
    }


    public List<ProductResponse> getAllProduct(Integer id) {

        List<Product> list;
        list=productRepository.findProductByIdNamedParamsNative(id);
        return  list.stream().map(p -> {
            return new ProductResponse(p);}).collect(Collectors.toList());

    }


    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }


    public String deleteProduct(Long productId) {
        Product product = productRepository.findById(productId).get();

        if (product != null) {
            productRepository.delete(product);
            return "Deletion successful!";
        }

        return "Something wrong on server";
    }


    public Product editProduct(Long productId, Product product) {

        Product oldProduct = productRepository.findById(productId).get();

        oldProduct.setProductName(product.getProductName());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setStock(product.getStock());

        return productRepository.save(oldProduct);
    }
}
