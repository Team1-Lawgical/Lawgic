package com.asiana.lawgic.lawgic.repository;

import com.asiana.lawgic.lawgic.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface ClientRepository extends JpaRepository<Client,Long> {
    @Query("SELECT client FROM Client client")
    public Object[] getAllClients();

//    @Query("SELECT COUNT(c.email) > 0 FROM Client c WHERE c.email = :inputEmail")
//    boolean findbyEmail(@Param("inputEmail")String inputEmail);

     Optional<Client> findClientByEmail(String email);

}
