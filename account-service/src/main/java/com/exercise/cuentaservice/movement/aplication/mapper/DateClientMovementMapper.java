package com.exercise.cuentaservice.movement.aplication.mapper;

import com.exercise.cuentaservice.movement.aplication.dtos.MovementReportDto;
import com.exercise.cuentaservice.movement.domain.entities.Movement;

public class DateClientMovementMapper {

    public static MovementReportDto dateClientMovementDtoToMovement(Movement movement, String nameClient) {

        return new MovementReportDto(
                movement.getDate(),
                nameClient,
                movement.getAccount().getId(),
                movement.getAccount().getType(),
                movement.getAccount().getBalance(),
                movement.getTypeMovement(),
                movement.getAccount().getState(),
                movement.getBalance()

        );

    }
}
