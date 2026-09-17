package com.upn.zonestylebackend.repository;

import com.upn.zonestylebackend.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReservaRepository extends JpaRepository<Reserva, Integer> {

}