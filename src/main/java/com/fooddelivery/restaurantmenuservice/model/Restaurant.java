package com.fooddelivery.restaurantmenuservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "restaurants")
public class Restaurant {
    @Id
    private String id;
    private String name;
    private String cuisine;
    private String city;
    private double rating;
    private boolean isOpen; // CRITICAL: Business rule check
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
}
