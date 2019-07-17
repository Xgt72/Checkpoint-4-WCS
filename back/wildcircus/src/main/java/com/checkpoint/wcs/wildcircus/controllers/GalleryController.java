package com.checkpoint.wcs.wildcircus.controllers;

import com.checkpoint.wcs.wildcircus.entities.Gallery;
import com.checkpoint.wcs.wildcircus.repositories.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class GalleryController {

    public GalleryController() { }

    @Autowired
    GalleryRepository galleryRepository;

    @GetMapping("/gallery")
    public List<Gallery> getAll() {
        return galleryRepository.findAll();
    }

    @GetMapping("/gallery/{id}")
    public Gallery getOneById(@PathVariable("id") Long id) {
        return galleryRepository.findById(id).get();
    }

    @PostMapping("/gallery")
    public Gallery create(@RequestBody Gallery gallery) throws Exception {
        return galleryRepository.save(gallery);
    }

    @PutMapping("/gallery/{id}")
    public Gallery update(@PathVariable("id") Long id, @RequestBody Gallery gallery) throws Exception {
        Gallery current = galleryRepository.findById(id).get();

        if (gallery.getFilename() != null) {
            current.setFilename(gallery.getFilename());
        }
        if (gallery.getCategory() != null) {
            current.setCategory(gallery.getCategory());
        }
        return galleryRepository.save(current);
    }

    @DeleteMapping("/gallery/{id}")
    public boolean delete(@PathVariable("id") Long id) throws Exception {
        galleryRepository.deleteById(id);
        return true;
    }
}
