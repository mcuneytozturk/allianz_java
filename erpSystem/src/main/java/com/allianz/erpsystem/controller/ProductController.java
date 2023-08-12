package com.allianz.erpsystem.controller;

import com.allianz.erpsystem.database.entity.ProductEntity;
import com.allianz.erpsystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("product/{uuid}")
    public ResponseEntity<ProductEntity> getProductByUUID(@PathVariable UUID uuid){
        ProductEntity product = productService.getProductByUUID(UUID.randomUUID());
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("create-product")
    public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductEntity product){
        ProductEntity product1 = productService.createProduct(product.getName(), product.getStockCount(), product.getProductDetail());

        return new ResponseEntity<>(product1, HttpStatus.CREATED);
    }

    @PutMapping("update-product/{uuid}")
    public ResponseEntity<ProductEntity> updateProductByUuid(@PathVariable UUID uuid, @RequestBody ProductEntity product){
        ProductEntity product1 = productService.updateProductByUUID(uuid, product);

        if(product1 != null){
            return new ResponseEntity<>(product1, HttpStatus.OK);
        }{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
