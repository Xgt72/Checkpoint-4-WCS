package com.checkpoint.wcs.wildcircus.controllers;

import com.checkpoint.wcs.wildcircus.entities.Ticket;
import com.checkpoint.wcs.wildcircus.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class TicketController {

    public TicketController() { }

    @Autowired
    TicketRepository ticketRepository;

    @GetMapping("/ticket")
    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    @GetMapping("/ticket/{id}")
    public Ticket getOneById(@PathVariable("id") Long id) {
        return ticketRepository.findById(id).get();
    }

    @PostMapping("/ticket")
    public Ticket create(@RequestBody Ticket ticket) throws Exception {
        return ticketRepository.save(ticket);
    }

    @PutMapping("/ticket/{id}")
    public Ticket update(@PathVariable("id") Long id, @RequestBody Ticket ticket) throws Exception {
        Ticket current = ticketRepository.findById(id).get();

        if (ticket.getCategory() != null) {
            current.setCategory(ticket.getCategory());
        }
        if (ticket.getPeriod() != null) {
            current.setPeriod(ticket.getPeriod());
        }
        if (ticket.getPrice() != null) {
            current.setPrice(ticket.getPrice());
        }
        return ticketRepository.save(current);
    }

    @DeleteMapping("/ticket/{id}")
    public boolean delete(@PathVariable("id") Long id) throws Exception {
        ticketRepository.deleteById(id);
        return true;
    }
}
