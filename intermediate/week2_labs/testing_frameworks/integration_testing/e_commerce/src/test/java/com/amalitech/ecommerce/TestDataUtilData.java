package com.amalitech.lab_2_ecommerce;

import com.amalitech.lab_2_ecommerce.entity.OrderEntity;
import com.amalitech.lab_2_ecommerce.entity.ProductEntity;

import java.util.List;

public class TestDataUtilData {
    public static ProductEntity productTestData() {
        return ProductEntity.builder()
                .price(5)
                .name("sean")
                .description("description")
                .build();
    }

    public static OrderEntity orderTestData(ProductEntity productEntity) {
        return OrderEntity.builder()
                .quantity(2)
                .products(List.of(productEntity))
                .build();
    }
}
