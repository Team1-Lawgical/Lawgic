package com.asiana.lawgic.lawgic.dao;

import com.asiana.lawgic.lawgic.entity.Lawyer;

import java.sql.SQLException;
import java.util.Collection;

public interface CategoryDAO {
    public Collection<Lawyer> getAllLawyers() throws SQLException;

}
