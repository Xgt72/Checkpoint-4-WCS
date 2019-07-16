package com.checkpoint.wcs.wildcircus.repositories;

import com.checkpoint.wcs.wildcircus.entities.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GalleryRepository extends JpaRepository<Gallery, Long> {
}
