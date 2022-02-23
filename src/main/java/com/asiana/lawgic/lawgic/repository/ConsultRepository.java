package com.asiana.lawgic.lawgic.repository;

import com.asiana.lawgic.lawgic.entity.Consult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ConsultRepository extends JpaRepository<Consult,Long> {
    @Query("SELECT consult from Consult consult")
    public Object[] getAllConsults();
}
