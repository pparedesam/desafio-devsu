package com.exercise.cuentaservice.account.aplication.dtos;

import java.math.BigDecimal;

public record AccountRequestDto(
        String accountType,
        BigDecimal initialBalance,
        Boolean status,
        Long idClient
        ) {


}
