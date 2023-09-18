package com.example.ecommerce.dao;

import com.example.ecommerce.model.Cart;
import com.example.ecommerce.model.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CartRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    public Cart createCartByUser(User user) {
        Cart cart = new Cart();
        cart.setUser(user);
        entityManager.persist(cart);
        return cart;
    }
}
