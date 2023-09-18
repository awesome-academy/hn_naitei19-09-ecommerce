package com.example.ecommerce.controller.cart.request;

import com.example.ecommerce.model.User;
import com.example.ecommerce.model.Product;

public class AddToCartRequest {
    private User user;
    private Product product;
    private int amount;

    // Getters and setters

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
