package com.exercise.cuentaservice.movement.infraestructure.adapters.web;

import com.exercise.cuentaservice.movement.aplication.port.DeleteMovementPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/movement")
public class DeleteMovementController {

    @Autowired
    private DeleteMovementPort deleteMovementPort;

    @DeleteMapping
    public ResponseEntity deleteMovement(@RequestParam("idMovement") Long idMovement){
        deleteMovementPort.deleteById(idMovement);
        return ResponseEntity.ok().build();
    }

}
