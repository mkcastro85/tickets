package com.partners.tickets.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "tickets")
public class TicketEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @PrePersist
    protected void onCreate() {
        creationDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updateDate = LocalDateTime.now();
    }
}