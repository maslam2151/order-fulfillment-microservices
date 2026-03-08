package com.example.inventory_service.controller;

import com.example.inventory_service.model.Inventory;
import com.example.inventory_service.repository.InventoryRepository;
import com.example.inventory_service.service.InventoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService service;
    private final InventoryRepository repository;

    public InventoryController(InventoryService service,
                               InventoryRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @GetMapping("/check")
    public boolean checkStock(
            @RequestParam String productId,
            @RequestParam int quantity) {

        return service.isInStock(productId, quantity);
    }

    @PostMapping
    public Inventory addInventory(@RequestBody Inventory inventory) {
        return repository.save(inventory);
    }
}