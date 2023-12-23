package com.exercise.cuentaservice.movement.domain.entities;

import com.exercise.cuentaservice.account.domain.entities.Account;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "movement")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String typeMovement;
    private BigDecimal value;
    private BigDecimal balance;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_account")
    private Account account;
}
