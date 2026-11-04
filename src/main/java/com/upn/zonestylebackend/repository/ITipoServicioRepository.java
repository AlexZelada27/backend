package com.upn.zonestylebackend.repository;

import com.upn.zonestylebackend.model.TipoServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoServicioRepository extends JpaRepository<TipoServicio, Integer> {
}
