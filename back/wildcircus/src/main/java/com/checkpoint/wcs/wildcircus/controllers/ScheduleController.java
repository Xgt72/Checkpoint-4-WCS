package com.checkpoint.wcs.wildcircus.controllers;

import com.checkpoint.wcs.wildcircus.entities.Schedule;
import com.checkpoint.wcs.wildcircus.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ScheduleController {

    public ScheduleController() { }

    @Autowired
    ScheduleRepository scheduleRepository;

    @GetMapping("/schedule")
    public List<Schedule> getAll() {
        return scheduleRepository.findAll();
    }

    @GetMapping("/schedule/{id}")
    public Schedule getOneById(@PathVariable("id") Long id) {
        return scheduleRepository.findById(id).get();
    }

    @PostMapping("/schedule")
    public Schedule create(@RequestBody Schedule schedule) throws Exception {
        return scheduleRepository.save(schedule);
    }

    @PutMapping("/schedule/{id}")
    public Schedule update(@PathVariable("id") Long id, @RequestBody Schedule schedule) throws Exception {
        Schedule current = scheduleRepository.findById(id).get();

        if (schedule.getPeriod() != null) {
            current.setPeriod(schedule.getPeriod());
        }
        if (schedule.getTimes() != null) {
            current.setTimes(schedule.getTimes());
        }
        if (schedule.getLocation() != null) {
            current.setLocation(schedule.getLocation());
        }
        return scheduleRepository.save(current);
    }

    @DeleteMapping("/schedule/{id}")
    public boolean delete(@PathVariable("id") Long id) throws Exception {
        scheduleRepository.deleteById(id);
        return true;
    }
}
