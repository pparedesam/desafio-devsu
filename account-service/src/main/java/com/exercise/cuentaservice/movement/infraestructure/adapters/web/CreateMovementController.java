package com.exercise.cuentaservice.movement.infraestructure.adapters.web;

import com.exercise.cuentaservice.movement.aplication.dtos.MovementRequestDto;
import com.exercise.cuentaservice.movement.aplication.dtos.MovementResponseDto;
import com.exercise.cuentaservice.movement.aplication.port.CreateMovementPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/movement")
public class CreateMovementController {
    @Autowired
    private CreateMovementPort createMovementPort;


    @PostMapping
    public ResponseEntity createMovement(@RequestBody MovementRequestDto movementRequestDto)
    {
        MovementResponseDto responseDto =  createMovementPort.execute(movementRequestDto);
        return ResponseEntity.ok(responseDto);
    }
}
