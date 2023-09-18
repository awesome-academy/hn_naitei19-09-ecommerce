package com.example.ecommerce.controller.cart.request;

import com.example.ecommerce.model.CartDetail;

public class RemoveFromCartRequest {
    private CartDetail cartDetail;

    // Getters and setters

    public CartDetail getCartDetail() {
        return cartDetail;
    }

    public void setCartDetail(CartDetail cartDetail) {
        this.cartDetail = cartDetail;
    }
}
