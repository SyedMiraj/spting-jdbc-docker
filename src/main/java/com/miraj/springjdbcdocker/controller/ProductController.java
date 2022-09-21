package com.miraj.springjdbcdocker.controller;

import com.miraj.springjdbcdocker.enity.Product;
import com.miraj.springjdbcdocker.repo.ProductRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        Product persistedProduct = productRepository.save(product);
        return ResponseEntity.ok(persistedProduct);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(productRepository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id){
        Optional<Product> product = productRepository.findById(id);
        return product.isPresent() ? ResponseEntity.ok(product.get()) : ResponseEntity.noContent().build();
    }
}
