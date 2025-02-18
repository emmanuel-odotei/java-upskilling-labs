package com.amalitech.lab_2_ecommerce.service;

import com.amalitech.lab_2_ecommerce.entity.ProductEntity;
import com.amalitech.lab_2_ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductEntity saveProduct(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }
}
