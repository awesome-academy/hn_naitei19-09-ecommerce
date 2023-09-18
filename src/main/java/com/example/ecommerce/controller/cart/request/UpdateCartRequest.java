package com.example.ecommerce.controller.cart.request;

import com.example.ecommerce.model.CartDetail;

public class UpdateCartRequest {
    private CartDetail cartDetail;
    private int amount;

    // Getters and setters

    public CartDetail getCartDetail() {
        return cartDetail;
    }

    public void setCartDetail(CartDetail cartDetail) {
        this.cartDetail = cartDetail;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
