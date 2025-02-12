package com.partners.tickets.repositories;

import com.partners.tickets.model.entities.TicketEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListCrudRepository;


public interface TicketRepository extends ListCrudRepository<TicketEntity, Long> {
    Page<TicketEntity> findAll(Pageable pageable);
}