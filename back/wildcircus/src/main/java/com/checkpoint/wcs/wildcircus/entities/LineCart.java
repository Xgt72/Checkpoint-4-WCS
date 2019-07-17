package com.checkpoint.wcs.wildcircus.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LineCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cart_id;
    private Long ticket_id;
    private Integer quantity;

    public LineCart() { }

    public LineCart(Long cart_id, Long ticket_id, Integer quantity) {
        this.cart_id = cart_id;
        this.ticket_id = ticket_id;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public Long getCart_id() {
        return cart_id;
    }

    public void setCart_id(Long cart_id) {
        this.cart_id = cart_id;
    }

    public Long getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(Long ticket_id) {
        this.ticket_id = ticket_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
