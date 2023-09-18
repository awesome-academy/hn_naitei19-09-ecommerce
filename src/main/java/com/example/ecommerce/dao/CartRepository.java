package com.example.ecommerce.dao;
// cart repository
import com.example.ecommerce.model.Cart;
import com.example.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart createCartByUser(User user);

    Cart findByUser(User user);

    boolean existsByUser(User user);

    void deleteByUser(User user);

    Cart save(Cart cart);
}