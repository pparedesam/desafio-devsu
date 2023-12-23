package com.exercise.cuentaservice.account.infraestructure.adapters.web;

import com.exercise.cuentaservice.account.aplication.port.DeleteAccountPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/account")
public class DeleteClientController {

    @Autowired
    private DeleteAccountPort deleteAccountPort;

    @DeleteMapping
    public ResponseEntity deleteAccount(@RequestParam("idAccount") Long idAccount){
        deleteAccountPort.deleteById(idAccount);
        return  ResponseEntity.ok().build();
    }
}
