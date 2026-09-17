package com.upn.zonestylebackend.repository;

import com.upn.zonestylebackend.model.ReservaServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReservaServicioRepository extends JpaRepository<ReservaServicio, Integer> {

}