package com.fooddelivery.restaurantmenuservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderValidationResponse {
    private boolean isValid;
    private String rejectionReason;
    private String restaurantCity; // Returned for Order Service to check Delivery constraint
    private BigDecimal calculatedItemsTotal;
    private List<ValidatedItem> validatedItems;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ValidatedItem {
        private String itemId;
        private BigDecimal price;
        private int quantity;
    }
}
