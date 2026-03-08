package com.example.order_service.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class InventoryClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public boolean checkStock(String productId, int quantity) {

        String url =
                "http://localhost:8081/inventory/check?productId="
                        + productId + "&quantity=" + quantity;

        Boolean response = restTemplate.getForObject(url, Boolean.class);

        return response != null && response;
    }
}