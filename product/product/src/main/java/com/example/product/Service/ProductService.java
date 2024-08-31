package com.example.product.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.Model.ProductModel;
import com.example.product.Repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    // Add product
    public ProductModel addProduct(ProductModel product) {
        return productRepository.save(product);
    }

    // Get products
    public List<ProductModel> getProducts() {
        return productRepository.findAll();
    }
    
    // Update product
    public ProductModel updateProduct( ProductModel product, int id) {
        ProductModel updateProduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));

        updateProduct.setName(product.getName());
        updateProduct.setDescription(product.getDescription());
        updateProduct.setPrice(product.getPrice());
        updateProduct.setRating(product.getRating());
        
        return productRepository.save(updateProduct);
    }

    // // Get product by ID
    public ProductModel getProduct(int id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // Delete product
    public void deleteProduct(int id) {
        productRepository.deleteById(id);        
    }
}