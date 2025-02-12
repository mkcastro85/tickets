package com.partners.tickets.services;

import com.partners.tickets.model.dtos.TicketDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TicketService {
    List<TicketDTO> getAll(Pageable pageable);
    TicketDTO create(String user);
    TicketDTO getById(Long id);
    TicketDTO update(Long id);
}
