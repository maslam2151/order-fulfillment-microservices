package com.example.order_service.service;

import com.example.order_service.client.InventoryClient;
import com.example.order_service.dto.OrderRequestDTO;
import com.example.order_service.dto.OrderResponseDTO;
import com.example.order_service.model.Order;
import com.example.order_service.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository repository;
    private final InventoryClient inventoryClient;

    public OrderService(OrderRepository repository,
                        InventoryClient inventoryClient) {
        this.repository = repository;
        this.inventoryClient = inventoryClient;
    }

    public OrderResponseDTO createOrder(OrderRequestDTO request) {

        boolean inStock = inventoryClient.checkStock(
                request.getProductId(),
                request.getQuantity()
        );

        if (!inStock) {
            throw new RuntimeException("Product not in stock");
        }

        Order order = new Order();
        order.setProductId(request.getProductId());
        order.setQuantity(request.getQuantity());
        order.setStatus("CREATED");

        Order saved = repository.save(order);

        return new OrderResponseDTO(
                saved.getId(),
                saved.getProductId(),
                saved.getQuantity(),
                saved.getStatus()
        );
    }

    public List<OrderResponseDTO> getAllOrders() {

        return repository.findAll()
                .stream()
                .map(order -> new OrderResponseDTO(
                        order.getId(),
                        order.getProductId(),
                        order.getQuantity(),
                        order.getStatus()
                ))
                .collect(Collectors.toList());
    }
}