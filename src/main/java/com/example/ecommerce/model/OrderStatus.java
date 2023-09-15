package com.example.ecommerce.model;

public enum OrderStatus {

    PENDING("Pending"),
    PROCESSING("Processing"),
    SHIPPED("Shipped"),
    DELIVERED("Delivered"),

    CANCELLED("Cancelled"),
    REJECTED("Rejecected");


    private final String status;

    OrderStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
