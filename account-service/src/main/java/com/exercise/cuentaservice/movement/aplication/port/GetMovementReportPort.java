package com.exercise.cuentaservice.movement.aplication.port;

import com.exercise.cuentaservice.movement.aplication.dtos.MovementByClient;
import com.exercise.cuentaservice.movement.aplication.dtos.MovementResponseDto;

import java.util.Date;
import java.util.List;

public interface GetMovementReportPort {
    List<MovementByClient> execute(Date dateIni, Date dateLast, Long idClient);
}
