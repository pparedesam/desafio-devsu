package com.exercise.cuentaservice.movement.infraestructure.repository;

import com.exercise.cuentaservice.movement.aplication.dtos.MovementByClient;
import com.exercise.cuentaservice.movement.domain.entities.Movement;
import com.exercise.cuentaservice.movement.domain.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class MovementReportRepositoryImpl implements GetMovementReportRepository {

    @Autowired
    private MovementReportJpaRepository movementReportJpaRepository;

    @Override
    public List<MovementByClient> findMovementByClients(Date dateIni , Date DateLast, Long idClient) {
        return movementReportJpaRepository.getMovementByClientReport(dateIni,DateLast,idClient);
    }
}
