package com.fooddelivery.restaurantmenuservice.controller;

import com.fooddelivery.restaurantmenuservice.dto.OrderValidationRequest;
import com.fooddelivery.restaurantmenuservice.dto.OrderValidationResponse;
import com.fooddelivery.restaurantmenuservice.model.Restaurant;
import com.fooddelivery.restaurantmenuservice.service.RestaurantMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable; [cite_start]// Used for pagination/filtering [cite: 35]
import java.util.List;

@RestController
@RequestMapping("/v1/restaurants")
@RequiredArgsConstructor
public class RestaurantMenuController {

    private final RestaurantMenuService service;

    // ----------------------------------------------------
    [cite_start]// CRITICAL API for Inter-Service Communication (Order Service) [cite: 56, 59]
    // ----------------------------------------------------

    /**
     * Synchronous call from Order Service to validate business rules and fetch pricing data.
     * Returns 409 Conflict if validation fails.
     */
    @PostMapping("/validate-order")
    public ResponseEntity<OrderValidationResponse> validateOrder(@RequestBody OrderValidationRequest request) {
        OrderValidationResponse response = service.validateOrder(request);

        if (!response.isValid()) {
            // Return 409 Conflict (Client Error) if business rule violated, indicating rejection
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }

        // Return 200 OK with pricing and city data
        return ResponseEntity.ok(response);
    }

    // ----------------------------------------------------
    // Public/Admin Endpoints (CRUD)
    // ----------------------------------------------------

    /**
     * [cite_start]List all restaurants with support for pagination and filtering. [cite: 35]
     */
    @GetMapping
    public ResponseEntity<List<Restaurant>> getAllRestaurants(
            @RequestParam(required = false) String city,
            [cite_start]Pageable pageable) { // Spring automatically handles pagination/filtering [cite: 35]

        // Actual implementation in the service layer would use pageable object
        // Placeholder return
        return ResponseEntity.ok(List.of(new Restaurant()));
    }
    
    // Additional endpoints for GET /v1/restaurants/{id}/menu and CRUD would go here
}
