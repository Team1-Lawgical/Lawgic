package com.asiana.lawgic.lawgic.repository;

import com.asiana.lawgic.lawgic.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ClientRepository extends JpaRepository<Client,Long> {
    @Query("SELECT client from Client client")
    public Object[] getAllClients();
}
