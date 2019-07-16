package com.checkpoint.wcs.wildcircus.repositories;

import com.checkpoint.wcs.wildcircus.entities.LineCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineCartRepository extends JpaRepository<LineCart, Long> {
}
