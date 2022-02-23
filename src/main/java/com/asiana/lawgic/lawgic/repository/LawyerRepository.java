package com.asiana.lawgic.lawgic.repository;

import com.asiana.lawgic.lawgic.entity.Lawyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LawyerRepository extends JpaRepository<Lawyer,Long> {
    //@Query("SELECT lawyer.lawyerId, lawyer.password, lawyer.gender, lawyer.email, lawyer.categoryId, lawyer.address, lawyer.name, lawyer.phone, lawyer.valid from Lawyer lawyer")
    @Query("SELECT lawyer from Lawyer lawyer")
    public Object[] getAllLawyers();
}
