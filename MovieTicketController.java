
package com.sathish.demo.controller;

import com.sathish.demo.model.MovieTicket;
import com.sathish.demo.service.MovieTicketService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/tickets")
public class MovieTicketController {

    private final MovieTicketService service;

    public MovieTicketController(MovieTicketService service) {
        this.service = service;
    }

    // Book multiple tickets
    @PostMapping
    public List<MovieTicket> bookTickets(
            @RequestBody List<@Valid MovieTicket> tickets) {

        List<MovieTicket> result = new ArrayList<>();

        for (MovieTicket ticket : tickets) {
            result.add(service.bookTicket(ticket));
        }

        return result;
    }

    // Get all tickets
    @GetMapping
    public List<MovieTicket> getAllTickets() {
        return service.getAllTickets();
    }

    // Get ticket by ID
    @GetMapping("/{id}")
    public ResponseEntity<MovieTicket> getTicketById(
            @PathVariable int id) {

        MovieTicket ticket = service.getTicketById(id);

        if (ticket == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(ticket);
    }
}




