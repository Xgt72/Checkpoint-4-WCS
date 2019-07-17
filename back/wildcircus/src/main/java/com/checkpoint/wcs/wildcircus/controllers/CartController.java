package com.checkpoint.wcs.wildcircus.controllers;

import com.checkpoint.wcs.wildcircus.entities.Cart;
import com.checkpoint.wcs.wildcircus.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CartController {

    public CartController() { }

    @Autowired
    CartRepository cartRepository;

    @GetMapping("/cart")
    public List<Cart> getAll() {
        return cartRepository.findAll();
    }

    @GetMapping("/cart/{id}")
    public Cart getOneById(@PathVariable("id") Long id) {
        return cartRepository.findById(id).get();
    }

    @PostMapping("/cart")
    public Cart create(@RequestBody Cart cart) throws Exception {
        return cartRepository.save(cart);
    }

    @PutMapping("/cart/{id}")
    public Cart update(@PathVariable("id") Long id, @RequestBody Cart cart) throws Exception {
        Cart current = cartRepository.findById(id).get();

        if (cart.getCustomer_id() != null) {
            current.setCustomer_id(cart.getCustomer_id());
        }
        return cartRepository.save(current);
    }

    @DeleteMapping("/cart/{id}")
    public boolean delete(@PathVariable("id") Long id) throws Exception {
        cartRepository.deleteById(id);
        return true;
    }
}
