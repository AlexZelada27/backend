package com.upn.zonestylebackend.repository;

import com.upn.zonestylebackend.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPagoRepository extends JpaRepository<Pago, Integer> {

}