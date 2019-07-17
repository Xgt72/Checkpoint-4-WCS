package com.checkpoint.wcs.wildcircus.controllers;

import com.checkpoint.wcs.wildcircus.entities.LineCart;
import com.checkpoint.wcs.wildcircus.repositories.LineCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class LineCartController {

    public LineCartController() { }

    @Autowired
    LineCartRepository lineCartRepository;

    @GetMapping("/line-cart")
    public List<LineCart> getAll() {
        return lineCartRepository.findAll();
    }

    @GetMapping("/line-cart/{id}")
    public LineCart getOneById(@PathVariable("id") Long id) {
        return lineCartRepository.findById(id).get();
    }

    @PostMapping("/line-cart")
    public LineCart create(@RequestBody LineCart lineCart) throws Exception {
        return lineCartRepository.save(lineCart);
    }

    @PutMapping("/line-cart/{id}")
    public LineCart update(@PathVariable("id") Long id, @RequestBody LineCart lineCart) throws Exception {
        LineCart current = lineCartRepository.findById(id).get();

        if (lineCart.getCart_id() != null) {
            current.setCart_id(lineCart.getCart_id());
        }
        if (lineCart.getTicket_id() != null) {
            current.setTicket_id(lineCart.getTicket_id());
        }
        if (lineCart.getQuantity() != null) {
            current.setQuantity(lineCart.getQuantity());
        }
        return lineCartRepository.save(current);
    }

    @DeleteMapping("/line-cart/{id}")
    public boolean delete(@PathVariable("id") Long id) throws Exception {
        lineCartRepository.deleteById(id);
        return true;
    }
}
