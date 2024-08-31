package com.example.product.Repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.product.Model.ProductModel;

@Repository
public interface  ProductRepository extends JpaRepository<ProductModel, Integer> {

    public ProductModel save(User updateUser);

    
}
