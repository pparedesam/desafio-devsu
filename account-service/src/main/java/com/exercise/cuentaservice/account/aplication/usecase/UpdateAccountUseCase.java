package com.exercise.cuentaservice.account.aplication.usecase;

import com.exercise.cuentaservice.account.aplication.port.UpdateAccountPort;
import com.exercise.cuentaservice.account.domain.entities.Account;
import com.exercise.cuentaservice.account.domain.repository.UpdateAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateAccountUseCase implements UpdateAccountPort {
    @Autowired
    private UpdateAccountRepository updateAccountRepository;


    @Override
    public Account update(Account account) {
        return updateAccountRepository.update(account);
    }
}
