package com.exercise.cuentaservice.account.aplication.usecase;

import com.exercise.cuentaservice.account.aplication.port.DeleteAccountPort;
import com.exercise.cuentaservice.account.domain.repository.DeleteAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteAccountUseCase implements DeleteAccountPort {

    @Autowired
    DeleteAccountRepository deleteAccountRepository;
    @Override
    public void deleteById(Long idAccount) {
        deleteAccountRepository.deleteById(idAccount);
    }
}
