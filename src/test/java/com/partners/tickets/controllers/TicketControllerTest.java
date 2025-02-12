package com.partners.tickets.controllers;

import com.partners.tickets.model.dtos.TicketDTO;
import com.partners.tickets.services.TicketService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import java.util.Collections;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TicketController.class)
class TicketControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TicketService ticketService;

    private TicketDTO ticketDTO;

    @BeforeEach
    void setUp() {
        ticketDTO =TicketDTO.builder()
                .id(1L)
                .username("Meyling")
                .build();

    }

    @Test
    void testCreateTicket() throws Exception {
        when(ticketService.create("Meyling")).thenReturn(ticketDTO);

        mockMvc.perform(post("/api/tickets")
                        .param("user", "Meyling")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.username").value("Meyling"));
    }

    @Test
    void testGetAllTickets() throws Exception {
        when(ticketService.getAll(any())).thenReturn(Collections.singletonList(ticketDTO));

        mockMvc.perform(get("/api/tickets")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].username").value("Meyling"));
    }

    @Test
    void testGetTicketById() throws Exception {
        when(ticketService.getById(1L)).thenReturn(ticketDTO);

        mockMvc.perform(get("/api/tickets/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.username").value("Meyling"));
    }

    @Test
    void testUpdateTicket() throws Exception {
        when(ticketService.update(1L)).thenReturn(ticketDTO);

        mockMvc.perform(put("/api/tickets/1/close")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.username").value("Meyling"));
    }
}