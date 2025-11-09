package com.fooddelivery.restaurantmenuservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "restaurants")
public class Restaurant {
    @Id
    private String id;
    private String name;
    private String cuisine;
    private String city;
    private Double rating;      // Using Double for simplicity
    private boolean isOpen;     // Mapped to 'open' in JSON
    private LocalDateTime createdAt;

    // --- FIX: REQUIRED NO-ARG CONSTRUCTOR ---
    // Spring Data needs this to create the object before setting properties.
    public Restaurant() {
        this.createdAt = LocalDateTime.now(); // Set default here
    }

    // --- Getters and Setters (Standard accessors) ---

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getCuisine() { return cuisine; }
    public void setCuisine(String cuisine) { this.cuisine = cuisine; }
    
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    
    public Double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }
    
    public boolean isOpen() { return isOpen; }
    public void setOpen(boolean open) { isOpen = open; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    // No equals/hashCode/toString/builder needed for basic mapping fix.
}