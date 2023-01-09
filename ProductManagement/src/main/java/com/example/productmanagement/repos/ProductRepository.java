package com.example.productmanagement.repos;


import com.example.productmanagement.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM product p WHERE p.user_id = :id",
            nativeQuery = true)
    List<Product> findProductByIdNamedParamsNative(@Param("id") Integer id);
}