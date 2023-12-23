package com.exercise.cuentaservice.movement.infraestructure.adapters.web;

import com.exercise.cuentaservice.movement.aplication.port.UpdateMovementPort;
import com.exercise.cuentaservice.movement.domain.entities.Movement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/movement")
public class UpdateMovementController {


    @Autowired
    private UpdateMovementPort updateMovementPort;

    @PutMapping
    public ResponseEntity updateMovement(@RequestBody Movement movement){
        Movement movementResponse = updateMovementPort.update(movement);
        return ResponseEntity.ok(movementResponse);
    }
}
