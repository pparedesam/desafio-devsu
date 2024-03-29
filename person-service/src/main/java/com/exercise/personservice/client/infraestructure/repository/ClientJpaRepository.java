package com.exercise.personservice.client.infraestructure.repository;

import com.exercise.personservice.client.domain.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientJpaRepository extends JpaRepository<Client,Long> {
    void deleteById(Long idPerson);
    Client findByPerson_Name(String name);

}
