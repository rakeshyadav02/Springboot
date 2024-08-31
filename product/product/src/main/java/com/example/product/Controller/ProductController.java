package com.example.product.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.Model.ProductModel;
import com.example.product.Service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Create Product
    @PostMapping("/createProduct")
    public ResponseEntity<ProductModel> createProduct(@RequestBody ProductModel product) {
        ProductModel createdProduct = productService.addProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    // Get all Products
    @GetMapping("/getProducts")
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        List<ProductModel> products = productService.getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // Get Product by ID
    @GetMapping("/getProduct/{id}")
    public ResponseEntity<ProductModel> getProductById(@PathVariable int id) {
        ProductModel product = productService.getProduct(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    // Update Product
    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<ProductModel> updateProduct(@RequestBody ProductModel product,@PathVariable int id) {
        ProductModel updatedProduct = productService.updateProduct(product, id);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    // Delete Product
    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}