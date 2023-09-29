
//package com.example.ecommerce;
//
//import com.example.ecommerce.controller.cart.CartController;
//import com.example.ecommerce.controller.cart.request.AddToCartRequest;
//import com.example.ecommerce.controller.cart.request.RemoveFromCartRequest;
//import com.example.ecommerce.controller.cart.request.UpdateCartRequest;
//import com.example.ecommerce.model.*;
//import com.example.ecommerce.service.CartService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//public class CartControllerTest {
//
//    @InjectMocks
//    private CartController cartController;
//
//    @Mock
//    private CartService cartService;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void testAddItemToCart() {
//        User user = new User();
//        user.setId(1L); // Thêm ID cho User
//        user.setFullname("John Doe"); // Thêm Fullname cho User
//
//        Category category = new Category();
//        category.setId(1L); // Thêm ID cho Category
//        category.setName("Electronics"); // Thêm Name cho Category
//
//        Product product = new Product();
//        product.setId(1L); // Thêm ID cho Product
//        product.setCategory(category);
//        product.setName("Smartphone");
//        product.setPrice(499.99); // Thêm giá cho Product
//        product.setImage("smartphone.jpg"); // Thêm hình ảnh cho Product
//        product.setBrand("Samsung"); // Thêm thương hiệu cho Product
//        product.setBuyCount(0); // Thêm số lần mua cho Product
//        product.setDescription("A high-end smartphone"); // Thêm mô tả cho Product
//        product.setQuantity(10); // Thêm số lượng cho Product
//
//        int amount = 2;
//        Cart cart = new Cart();
//        cart.setId(1L); // Thêm ID cho Cart
//
//        when(cartService.addItemToCart(user, product, amount)).thenReturn(cart);
//
//        AddToCartRequest request = new AddToCartRequest();
//        request.setUser(user);
//        request.setProduct(product);
//        request.setAmount(amount);
//
//        ResponseEntity<Cart> response = cartController.addItemToCart(request);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(cart, response.getBody());
//    }
//
//    @Test
//    public void testUpdateCartItem() {
//        CartDetail cartDetail = new CartDetail();
//        cartDetail.setId(1L); // Thêm ID cho CartDetail
//
//        int amount = 3;
//        Cart cart = new Cart();
//        cart.setId(1L); // Thêm ID cho Cart
//
//        when(cartService.updateCartItem(cartDetail, amount)).thenReturn(cart);
//
//        UpdateCartRequest request = new UpdateCartRequest();
//        request.setCartDetail(cartDetail);
//        request.setAmount(amount);
//
//        ResponseEntity<Cart> response = cartController.updateCartItem(request);
//
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(cart, response.getBody());
//    }
//
//    @Test
//    public void testRemoveItemFromCart() {
//        CartDetail cartDetail = new CartDetail();
//        cartDetail.setId(1L); // Thêm ID cho CartDetail
//
//        RemoveFromCartRequest request = new RemoveFromCartRequest();
//        request.setCartDetail(cartDetail);
//
//        ResponseEntity<Void> response = cartController.removeItemFromCart(request);
//
//        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
//        verify(cartService, times(1)).removeItemFromCart(cartDetail);
//    }
//}

