package com.exercise.cuentaservice.account.aplication.usecase;

import com.exercise.cuentaservice.account.aplication.dtos.AccountResponseDto;
import com.exercise.cuentaservice.account.aplication.dtos.ClientResponseDto;
import com.exercise.cuentaservice.account.aplication.port.GetAccountPort;
import com.exercise.cuentaservice.account.domain.repository.GetAccountRepository;
import com.exercise.cuentaservice.account.infraestructure.client.PersonServiceClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAccountUseCase implements GetAccountPort {

    @Autowired
    private GetAccountRepository getAccountRepository;

    @Autowired
    private PersonServiceClient personServiceClient;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<AccountResponseDto> execute() {

        return getAccountRepository.findAll().stream()
                .map(account -> {
                    String reponse = personServiceClient.getClient(account.getIdClient());
                    ClientResponseDto clientResponseDto;
                    try {
                        clientResponseDto = objectMapper.readValue(reponse, ClientResponseDto.class);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                    return new AccountResponseDto(
                            account.getId(),
                            account.getType(),
                            account.getBalance(),
                            account.getState(),
                            clientResponseDto.name(),
                            account.getNumber()

                    );
                })
                .toList();


    }
}
