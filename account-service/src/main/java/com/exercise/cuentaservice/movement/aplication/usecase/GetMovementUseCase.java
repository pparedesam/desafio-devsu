package com.exercise.cuentaservice.movement.aplication.usecase;

import com.exercise.cuentaservice.movement.aplication.dtos.MovementResponseDto;
import com.exercise.cuentaservice.movement.aplication.mapper.MovementMapper;
import com.exercise.cuentaservice.movement.aplication.port.GetMovementPort;
import com.exercise.cuentaservice.movement.domain.entities.Movement;
import com.exercise.cuentaservice.movement.domain.repository.GetMovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GetMovementUseCase implements GetMovementPort {

    @Autowired
    private GetMovementRepository getMovementRepository;
    @Override
    public List<MovementResponseDto> execute() {
        List<Movement> movements = getMovementRepository.findAll();
        return movements.stream()
                .map(MovementMapper::movementToMovementResponseDto)
                .toList();
    }
}
