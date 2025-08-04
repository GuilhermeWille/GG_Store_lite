package com.ggstore.controller;

import com.ggstore.model.CartItem;
import com.ggstore.service.CartService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "*")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService){
        this.cartService = cartService;
    }

    @GetMapping
    public List<CartItem> getCartItems(){
        return cartService.getCartItems();
    }
    
    @PostMapping("/add")
    public void addToCart(@RequestBody CartItem cartItem){
        cartService.addToCart(cartItem.getProductId(), cartItem.getQuantity());
    }
}