package com.upn.zonestylebackend.repository;

import com.upn.zonestylebackend.model.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServicioRepository extends JpaRepository<Servicio, Integer> {
}
