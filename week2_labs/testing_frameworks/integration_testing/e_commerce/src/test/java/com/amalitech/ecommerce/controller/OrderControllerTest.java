package com.amalitech.lab_2_ecommerce.controller;

import com.amalitech.lab_2_ecommerce.TestDataUtilData;
import com.amalitech.lab_2_ecommerce.entity.OrderEntity;
import com.amalitech.lab_2_ecommerce.entity.ProductEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
class OrderControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testOrderController() throws Exception {
        // Prepare test data
        OrderEntity orderData = TestDataUtilData.orderTestData(TestDataUtilData.productTestData());
        orderData.setQuantity(2);
        // Convert the OrderEntity to form parameters
        String orderDataString = "quantity=" + orderData.getQuantity();

        ProductEntity productData = TestDataUtilData.productTestData();
        productData.setId(1L);

        String productDataString = "products[0].name=" + productData.getName()
                +"&products[0].price="+productData.getPrice()
                +"&products[0].description="+productData.getDescription();
        String requestParams = orderDataString + "&" + productDataString;

        mockMvc.perform(MockMvcRequestBuilders.post("/place/order")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .content(requestParams)
                ).andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/orders"));
    }
}