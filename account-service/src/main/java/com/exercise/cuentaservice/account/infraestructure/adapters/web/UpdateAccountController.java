package com.exercise.cuentaservice.account.infraestructure.adapters.web;

import com.exercise.cuentaservice.account.aplication.port.UpdateAccountPort;
import com.exercise.cuentaservice.account.domain.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/account")
public class UpdateAccountController {

    @Autowired
    private UpdateAccountPort updateAccountPort;

    @PutMapping
    public ResponseEntity updateAccount(@RequestBody Account account){
        Account accountResponse = updateAccountPort.update(account);
        return  ResponseEntity.ok(accountResponse);
    }
}
