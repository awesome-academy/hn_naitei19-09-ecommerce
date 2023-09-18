package com.example.ecommerce.dao;

import com.example.ecommerce.model.Cart;
import com.example.ecommerce.model.CartDetail;
import com.example.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {

    List<CartDetail> findByCart(Cart cart);

    CartDetail findByProductAndCart(Product product, Cart cart);

    boolean existsByProductAndCart(Product product, Cart cart);

    @Query("SELECT SUM(cd.amount) FROM CartDetail cd WHERE cd.cart = :cart")
    int getTotalProductCountInCart(@Param("cart") Cart cart);
}
