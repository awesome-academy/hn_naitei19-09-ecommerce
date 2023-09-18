package com.example.ecommerce.service;

import com.example.ecommerce.model.Cart;
import com.example.ecommerce.model.CartDetail;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.User;
import com.example.ecommerce.dao.CartDetailRepository;
import com.example.ecommerce.dao.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartDetailRepository cartDetailRepository;

    public Cart addItemToCart(User user, Product product, int amount) {
        // Kiểm tra xem người dùng đã có giỏ hàng hay chưa
        Cart cart = cartRepository.findByUser(user);
        if (cart == null) {
            cart = new Cart();
            cart.setUser(user);
        }

        // Kiểm tra xem sản phẩm đã tồn tại trong giỏ hàng chưa
        boolean productExistsInCart = cartDetailRepository.existsByProductAndCart(product, cart);

        if (productExistsInCart) {
            // Sản phẩm đã tồn tại trong giỏ hàng, cập nhật số lượng
            CartDetail cartDetail = cartDetailRepository.findByProductAndCart(product, cart);
            cartDetail.setAmount(cartDetail.getAmount() + amount);
        } else {
            // Sản phẩm chưa tồn tại trong giỏ hàng, tạo mới chi tiết giỏ hàng
            CartDetail cartDetail = new CartDetail();
            cartDetail.setCart(cart);
            cartDetail.setProduct(product);
            cartDetail.setAmount(amount);
            cartDetailRepository.save(cartDetail);
        }

        // Lưu giỏ hàng
        return cartRepository.save(cart);
    }

    public Cart updateCartItem(CartDetail cartDetail, int amount) {
        // Cập nhật số lượng sản phẩm trong chi tiết giỏ hàng
        cartDetail.setAmount(amount);

        // Lưu chi tiết giỏ hàng
        cartDetailRepository.save(cartDetail);

        // Lấy lại giỏ hàng để cập nhật tổng số tiền, nếu cần
        return cartRepository.findById(cartDetail.getCart().getId()).orElse(null);
    }

    public void removeItemFromCart(CartDetail cartDetail) {
        // Xóa sản phẩm khỏi giỏ hàng
        cartDetailRepository.delete(cartDetail);
    }
}
