package com.upn.zonestylebackend.repository;

import com.upn.zonestylebackend.model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHorarioRepository extends JpaRepository<Horario, Integer> {

}