package com.example.ecommerce.controller.cart;

import com.example.ecommerce.model.*;
import com.example.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ecommerce.controller.cart.request.AddToCartRequest;
import com.example.ecommerce.controller.cart.request.UpdateCartRequest;
import com.example.ecommerce.controller.cart.request.RemoveFromCartRequest;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<Cart> addItemToCart(@RequestBody AddToCartRequest request) {
        User user = request.getUser();
        Product product = request.getProduct();
        int amount = request.getAmount();

        Cart updatedCart = cartService.addItemToCart(user, product, amount);

        return ResponseEntity.ok(updatedCart);
    }

    @PutMapping("/update")
    public ResponseEntity<Cart> updateCartItem(@RequestBody UpdateCartRequest request) {
        CartDetail cartDetail = request.getCartDetail();
        int amount = request.getAmount();

        Cart updatedCart = cartService.updateCartItem(cartDetail, amount);

        return ResponseEntity.ok(updatedCart);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Void> removeItemFromCart(@RequestBody RemoveFromCartRequest request) {
        CartDetail cartDetail = request.getCartDetail();

        cartService.removeItemFromCart(cartDetail);

        return ResponseEntity.noContent().build();
    }
}
