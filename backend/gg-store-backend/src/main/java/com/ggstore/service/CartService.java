package com.ggstore.service;

import com.ggstore.model.CartItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CartService{
    private final List<CartItem> cartItem = new ArrayList<>();

    public void addToCart(String producId, int quantity){
        cartItem.add(new CartItem(producId, quantity));
        
    }
    public List<CartItem> getCartItems(){
        return cartItem;
    }
}