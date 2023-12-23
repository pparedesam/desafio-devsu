package com.exercise.cuentaservice.account.aplication.port;

import com.exercise.cuentaservice.account.domain.entities.Account;

public interface UpdateAccountPort {
    Account update(Account account);
}
