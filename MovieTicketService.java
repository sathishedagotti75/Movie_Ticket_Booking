package com.sathish.demo.service;

import com.sathish.demo.model.MovieTicket;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class MovieTicketService {

    private Map<Integer, MovieTicket> tickets = new HashMap<>();
    private int nextId = 1;

    public MovieTicket bookTicket(MovieTicket ticket) {
        ticket.setTicketId(nextId++);
        tickets.put(ticket.getTicketId(), ticket);
        return ticket;
    }

    public List<MovieTicket> getAllTickets() {
        return new ArrayList<>(tickets.values());
    }
    
    
    public MovieTicket getTicketById(int id) {
        return tickets.get(id);
    }
}

