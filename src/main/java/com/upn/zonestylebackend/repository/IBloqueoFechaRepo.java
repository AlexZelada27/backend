package com.upn.zonestylebackend.repository;

import com.upn.zonestylebackend.model.BloqueoFecha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBloqueoFechaRepo extends JpaRepository<BloqueoFecha, Integer> {
}