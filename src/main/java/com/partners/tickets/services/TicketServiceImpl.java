package com.partners.tickets.services;

import com.partners.tickets.model.dtos.TicketDTO;
import com.partners.tickets.model.entities.StatusEnum;
import com.partners.tickets.model.entities.TicketEntity;
import com.partners.tickets.repositories.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService{

    private TicketRepository ticketRepository;

    @Override
    public List<TicketDTO> getAll(Pageable pageable) {
        return ticketRepository.findAll(pageable)
                .stream()
                .map(result->TicketDTO.builder()
                        .creationDate(result.getCreationDate())
                        .updateDate(result.getUpdateDate())
                        .id(result.getId())
                        .username(result.getUsername())
                        .status(result.getStatus())
                        .build())
                .toList();
    }

    @Override
    public TicketDTO create(String user) {
        TicketEntity ticket = new TicketEntity();
        ticket.setUsername(user);
        ticket.setStatus(StatusEnum.OPEN);
        TicketEntity result=ticketRepository.save(ticket);
        return TicketDTO.builder()
                .creationDate(result.getCreationDate())
                .updateDate(result.getUpdateDate())
                .id(result.getId())
                .username(result.getUsername())
                .status(result.getStatus())
                .build();
    }

    @Override
    public TicketDTO getById(Long id) {
        TicketEntity ticket=ticketRepository.findById(id).orElseThrow();
        return TicketDTO.builder()
                .creationDate(ticket.getCreationDate())
                .updateDate(ticket.getUpdateDate())
                .id(ticket.getId())
                .username(ticket.getUsername())
                .status(ticket.getStatus())
                .build();
    }

    @Override
    public TicketDTO update(Long id) {
        TicketEntity ticket=ticketRepository.findById(id).orElseThrow();
        ticket.setStatus(StatusEnum.CLOSE);
        ticket = ticketRepository.save(ticket);
        return TicketDTO.builder()
                .creationDate(ticket.getCreationDate())
                .updateDate(ticket.getUpdateDate())
                .id(ticket.getId())
                .username(ticket.getUsername())
                .status(ticket.getStatus())
                .build();
    }
}
