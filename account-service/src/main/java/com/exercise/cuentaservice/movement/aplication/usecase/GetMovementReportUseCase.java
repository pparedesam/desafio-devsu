package com.exercise.cuentaservice.movement.aplication.usecase;

import com.exercise.cuentaservice.movement.aplication.dtos.MovementByClient;
import com.exercise.cuentaservice.movement.aplication.dtos.MovementResponseDto;
import com.exercise.cuentaservice.movement.aplication.mapper.MovementMapper;
import com.exercise.cuentaservice.movement.aplication.port.GetMovementPort;
import com.exercise.cuentaservice.movement.aplication.port.GetMovementReportPort;
import com.exercise.cuentaservice.movement.domain.entities.Movement;
import com.exercise.cuentaservice.movement.domain.repository.GetMovementReportRepository;
import com.exercise.cuentaservice.movement.domain.repository.GetMovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GetMovementReportUseCase implements GetMovementReportPort {

    @Autowired
    private GetMovementReportRepository getMovementReportRepository;
    @Override
    public List<MovementByClient> execute(Date dateIni, Date dateLast, Long idClient) {
        return getMovementReportRepository.findMovementByClients(dateIni,dateLast,idClient);
    }
}
