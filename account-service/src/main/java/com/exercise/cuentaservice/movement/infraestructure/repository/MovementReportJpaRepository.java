package com.exercise.cuentaservice.movement.infraestructure.repository;

import com.exercise.cuentaservice.movement.aplication.dtos.MovementByClient;
import com.exercise.cuentaservice.movement.domain.entities.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MovementReportJpaRepository extends JpaRepository<Movement,Long> {
    @Query(value = "select m.date, p.name, a.number, a.type, m.balance, a.state, m.value, \n" +
            "m.balance + m.value as Available \n" +
            "from account a \n" +
            "join movement m \n" +
            "on m.id_account = a.id \n" +
            "join client c\n" +
            "on c.id = a.id_client \n" +
            "join person p \n" +
            "on p.id = c.person_id \n" +
            "where a.id=:idClient and m.date BETWEEN :dateIni AND :dateLast",nativeQuery = true)
    List<MovementByClient> getMovementByClientReport(Date dateIni, Date dateLast, Long idClient);



}
