package com.fooddelivery.restaurantmenuservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field; // Import Field
import java.time.LocalDateTime;

@Document(collection = "restaurants")
public class Restaurant {
    @Id
    private String id;
    private String name;
    private String cuisine;
    private String city;
    
    // Explicitly mapping the fields to avoid issues with Double/boolean mapping
    @Field("rating")
    private Double rating;      
    
    @Field("isOpen")
    private boolean isOpen;     
    
    private LocalDateTime createdAt;

    // Required No-Argument Constructor for Spring Data Mapping
    public Restaurant() {
        this.createdAt = LocalDateTime.now();
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
    
    // FIXED GETTER: The getter must match the field name if the field is Boolean/boolean
    public boolean isIsOpen() { return isOpen; }
    // FIXED SETTER: Setter must match the standard Java Bean convention
    public void setIsOpen(boolean isOpen) { this.isOpen = isOpen; } 
    
    // Backwards-compatible accessors: many callers expect isOpen()/setOpen()
    // Provide them alongside the isIsOpen()/setIsOpen() to avoid breaking code.
    public boolean isOpen() { return this.isOpen; }
    public void setOpen(boolean open) { this.isOpen = open; }
    
    // Changing the getter/setter for the boolean flag to match the field name 'isOpen' 
    // is a common fix for manual models.
    // The previous getter 'isOpen()' conflicted with JSON output convention 'open'.
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}