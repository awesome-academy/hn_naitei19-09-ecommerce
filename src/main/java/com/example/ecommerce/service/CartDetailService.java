package com.example.ecommerce.service;

import com.example.ecommerce.model.Cart;
import com.example.ecommerce.model.CartDetail;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.dao.CartDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartDetailService {

    @Autowired
    private CartDetailRepository cartDetailRepository;

    public List<CartDetail> getCartDetailsByCart(Cart cart) {
        return cartDetailRepository.findByCart(cart);
    }

    public CartDetail getCartDetailByProductAndCart(Product product, Cart cart) {
        return cartDetailRepository.findByProductAndCart(product, cart);
    }

    public boolean doesProductExistInCart(Product product, Cart cart) {
        return cartDetailRepository.existsByProductAndCart(product, cart);
    }

    public int getTotalProductCountInCart(Cart cart) {
        return cartDetailRepository.getTotalProductCountInCart(cart);
    }

    public CartDetail saveCartDetail(CartDetail cartDetail) {
        return cartDetailRepository.save(cartDetail);
    }

    public void deleteCartDetail(CartDetail cartDetail) {
        cartDetailRepository.delete(cartDetail);
    }
}
