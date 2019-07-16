package com.checkpoint.wcs.wildcircus.controllers;

import com.checkpoint.wcs.wildcircus.entities.Performance;
import com.checkpoint.wcs.wildcircus.repositories.PerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class PerformanceController {

    public PerformanceController() { }

    @Autowired
    PerformanceRepository performanceRepository;

    @GetMapping("/performance")
    public List<Performance> getAll() {
        return performanceRepository.findAll();
    }

    @PostMapping("/performance")
    public Performance create(@RequestBody Performance performance) throws Exception {
        return performanceRepository.save(performance);
    }

    @PutMapping("/performance/{id}")
    public Performance update(@PathVariable("id") Long id, @RequestBody Performance performance) throws Exception {
        Performance current = performanceRepository.findById(id).get();

        if (performance.getTitle() != null) {
            current.setTitle(performance.getTitle());
        }
        if (performance.getContent() != null) {
            current.setContent(performance.getContent());
        }
        return performanceRepository.save(current);
    }

    @DeleteMapping("/performance/{id}")
    public boolean delete(@PathVariable("id") Long id) throws Exception {
        performanceRepository.deleteById(id);
        return true;
    }
}
