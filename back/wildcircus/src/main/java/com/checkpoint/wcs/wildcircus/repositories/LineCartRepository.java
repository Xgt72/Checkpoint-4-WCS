package com.checkpoint.wcs.wildcircus.repositories;

import com.checkpoint.wcs.wildcircus.entities.LineCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LineCartRepository extends JpaRepository<LineCart, Long> {
    @Query(value = "SELECT * FROM line_cart l WHERE l.cart_id = :cartId", nativeQuery = true)
    List<LineCart> findAllByCartId(@Param("cartId") Long cart_id);
}
