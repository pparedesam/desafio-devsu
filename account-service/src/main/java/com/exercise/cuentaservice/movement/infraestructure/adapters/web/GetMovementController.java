package com.exercise.cuentaservice.movement.infraestructure.adapters.web;

import com.exercise.cuentaservice.movement.aplication.dtos.MovementResponseDto;
import com.exercise.cuentaservice.movement.aplication.port.GetMovementPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/movement")
public class GetMovementController {

    @Autowired
    private GetMovementPort getMovementPort;

    @GetMapping()
    public ResponseEntity<List<MovementResponseDto>> getMovement(){
        List<MovementResponseDto> movements = getMovementPort.execute();
        return ResponseEntity.ok(movements);
    }
}
