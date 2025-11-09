package com.fooddelivery.restaurantmenuservice.repository;

import com.fooddelivery.restaurantmenuservice.model.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface RestaurantRepository extends MongoRepository<Restaurant, String> {
    List<Restaurant> findByCity(String city);
}
