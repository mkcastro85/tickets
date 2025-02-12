package com.partners.tickets.model.dtos;

import com.partners.tickets.model.entities.StatusEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class TicketDTO {


    private Long id;
    private String username;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
    private StatusEnum status;


}
