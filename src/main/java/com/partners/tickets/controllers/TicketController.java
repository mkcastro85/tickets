package com.partners.tickets.controllers;

import com.partners.tickets.model.dtos.TicketDTO;
import com.partners.tickets.services.TicketService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public ResponseEntity<TicketDTO> create(@RequestParam String user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ticketService.create(user));
    }

    @GetMapping
    public List<TicketDTO> getAll(@PageableDefault(size = 10) Pageable pageable) {
        return ticketService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ticketService.getById(id));
    }

    @PutMapping("/{id}/close")
    public ResponseEntity<TicketDTO> update(@PathVariable Long id) {
        return ResponseEntity.ok(ticketService.update(id));
    }
}