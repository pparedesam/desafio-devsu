package com.exercise.personservice.client.application.usecase;

import com.exercise.personservice.client.application.dtos.ClientRequestDto;
import com.exercise.personservice.client.application.dtos.ClientResponseDto;
import com.exercise.personservice.client.application.mapper.ClientMapper;
import com.exercise.personservice.client.application.port.GetClientByIdClientPort;
import com.exercise.personservice.client.application.port.UpdateClientPort;
import com.exercise.personservice.client.domain.entities.Client;
import com.exercise.personservice.client.domain.repository.GetClientRepository;
import com.exercise.personservice.client.domain.repository.UpdateClientRepository;
import com.exercise.personservice.person.application.port.UpdatePersonPort;
import com.exercise.personservice.person.domain.entities.Person;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateClientUseCase implements UpdateClientPort {

    @Autowired
    private UpdateClientRepository updateClientRepository;

   @Autowired
   private GetClientRepository getClientRepository;





    @Override
    @Transactional
    public ClientResponseDto update(ClientRequestDto clientRequestDto) {

        Client client = getClientRepository.findById(clientRequestDto.idClient());

        client.setPassword(clientRequestDto.password());
        client.setState(clientRequestDto.state());

        client.getPerson().setName(clientRequestDto.name());
        client.getPerson().setAddress(clientRequestDto.address());
        client.getPerson().setPhone(clientRequestDto.phone());

        Client clientResponse = updateClientRepository.update(client);
        return ClientMapper.clientToClientDto(clientResponse) ;
    }


}
