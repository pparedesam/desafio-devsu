package com.exercise.cuentaservice.account.aplication.usecase;

import com.exercise.cuentaservice.account.aplication.dtos.AccountRequestDto;
import com.exercise.cuentaservice.account.aplication.dtos.AccountResponseDto;
import com.exercise.cuentaservice.account.aplication.dtos.ClientResponseDto;
import com.exercise.cuentaservice.account.aplication.mapper.AccountMapper;
import com.exercise.cuentaservice.account.aplication.port.CreateAccountPort;
import com.exercise.cuentaservice.account.domain.entities.Account;
import com.exercise.cuentaservice.account.domain.repository.CreateAccountRepository;
import com.exercise.cuentaservice.account.domain.repository.GetAccountRepository;
import com.exercise.cuentaservice.account.infraestructure.client.PersonServiceClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateAccountUseCase implements CreateAccountPort {

    @Autowired
    private CreateAccountRepository createAccountRepository;

    @Autowired
    private GetAccountRepository getAccountRepository;

    @Autowired
    private PersonServiceClient personServiceClient;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public AccountResponseDto execute(AccountRequestDto accountRequestDto) {

        Account account = AccountMapper.accountDtoToAccount(accountRequestDto);
        account.setNumber(getAccountNumber());
        Account accountResponse = createAccountRepository.create(account);
        ClientResponseDto clientResponseDto = findClientById(accountResponse.getIdClient());
        return AccountMapper.accountToAccountDto(accountResponse, clientResponseDto.name());
    }

    private String getAccountNumber(){
        String lastNumber = getAccountRepository.findTopByOrderByNumberDesc();
        return StringUtils.isBlank(lastNumber) ? "1" : String.valueOf(Integer.parseInt(lastNumber) + 1);
    }

    private ClientResponseDto findClientById(Long id){
        try{
            String response = personServiceClient.getClient(id);
            return objectMapper.readValue(response,ClientResponseDto.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
