package com.checkpoint.wcs.wildcircus.repositories;

import com.checkpoint.wcs.wildcircus.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
