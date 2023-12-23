package com.exercise.personservice.client.application.port;

import com.exercise.personservice.client.application.dtos.ClientRequestDto;
import com.exercise.personservice.client.application.dtos.ClientResponseDto;
import com.exercise.personservice.client.domain.entities.Client;

public interface UpdateClientPort {
    ClientResponseDto update(ClientRequestDto clientRequestDto);
}
