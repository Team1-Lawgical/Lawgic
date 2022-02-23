package com.asiana.lawgic.lawgic.repository;

import com.asiana.lawgic.lawgic.entity.Consult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ConsultRepository extends JpaRepository<Consult,Long> {
    @Query("SELECT consult from Consult consult")
    public Object[] getAllConsults();

    @Query("SELECT consult from Consult consult where consult.lawyer.lawyerId=:lawyerId AND consult.client.clientId=:clientId")
    public Consult getConsultByLawyerAndClientId(Long lawyerId, Long clientId);
}
