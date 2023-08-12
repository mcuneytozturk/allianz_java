package com.allianz.erpsystem.service;

import com.allianz.erpsystem.database.entity.OrderEntity;
import com.allianz.erpsystem.database.entity.ProductEntity;
import com.allianz.erpsystem.database.repository.ProductEntityRepository;
import com.allianz.erpsystem.model.Order;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    ProductEntityRepository productEntityRepository;

    public ProductEntity createProduct(String name, int stockCount, String productDetail) {
        ProductEntity product = new ProductEntity();
        product.setName(name);
        product.setStockCount(stockCount);
        product.setProductDetail(productDetail);

        productEntityRepository.save(product);

        return product;
    }

    public ProductEntity getProductByUUID(UUID uuid){
        return productEntityRepository.findByUuid(uuid).orElse(null);
    }

    @Transactional
    public  ProductEntity updateProductByUUID(UUID uuid, ProductEntity product){
        ProductEntity product1 = getProductByUUID(uuid);

        if(product1 != null){
            product1.setName(product.getName());
            product1.setStockCount(product.getStockCount());
            product1.setProductDetail(product.getProductDetail());

            productEntityRepository.save(product1);

            return product1;
        } else {
            return null;
        }
    }
}
