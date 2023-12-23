package com.exercise.cuentaservice.account.infraestructure.adapters.web;

import com.exercise.cuentaservice.account.aplication.dtos.AccountResponseDto;
import com.exercise.cuentaservice.account.aplication.port.GetAccountPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/account")
public class GetAccountController {

    @Autowired
    private GetAccountPort getAccountPort;

    @GetMapping()
    public ResponseEntity<List<AccountResponseDto>> getAccount(){

        List<AccountResponseDto> accounts = getAccountPort.execute();
        return ResponseEntity.ok(accounts);
    }



}
