package com.exercise.cuentaservice.account.infraestructure.repository;

import com.exercise.cuentaservice.account.domain.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountJpaRepository extends JpaRepository<Account,Long> {
    void deleteById(Long idAccount);
    @Query("SELECT MAX(a.number) FROM Account a")
    String findMaxNumber();
}
