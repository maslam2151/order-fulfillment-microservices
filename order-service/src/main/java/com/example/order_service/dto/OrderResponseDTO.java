package com.example.order_service.dto;

import java.util.UUID;

public class OrderResponseDTO {

    private UUID id;
    private String productId;
    private int quantity;
    private String status;

    public OrderResponseDTO(UUID id, String productId, int quantity, String status) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }
}