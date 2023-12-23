package com.exercise.cuentaservice.movement.infraestructure.adapters.web;

import com.exercise.cuentaservice.movement.aplication.dtos.MovementByClient;
import com.exercise.cuentaservice.movement.aplication.port.GetMovementReportPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/reports")
public class GetMovementReportController {

    @Autowired
    private GetMovementReportPort getMovementReportPort;

    @GetMapping()
    public ResponseEntity<List<MovementByClient>> getMovementbyClient(@RequestParam("dateIni") Date dateIni,@RequestParam("dateLast") Date dateLast,@RequestParam("idClient") Long idClient){
        List<MovementByClient> movements = getMovementReportPort.execute(dateIni,dateLast,idClient);
        return ResponseEntity.ok(movements);
    }
}
