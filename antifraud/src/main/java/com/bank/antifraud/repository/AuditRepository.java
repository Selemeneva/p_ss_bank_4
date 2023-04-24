package com.bank.antifraud.repository;

import com.bank.antifraud.entity.Audit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AuditRepository extends JpaRepository<Audit, Long> {
    Audit findFirstByEntityTypeAndEntityJsonContainingOrderByIdDesc(String type, String word);


}
