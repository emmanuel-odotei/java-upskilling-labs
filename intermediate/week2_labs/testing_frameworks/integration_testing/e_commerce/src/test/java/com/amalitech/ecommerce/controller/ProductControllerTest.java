package com.amalitech.lab_2_ecommerce.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void TestFindAllProducts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products")
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(view().name("products"))
                .andExpect(MockMvcResultMatchers.model().attribute("products", List.of()))
        ;
    }
}