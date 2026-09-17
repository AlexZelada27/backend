package com.upn.zonestylebackend.repository;

import com.upn.zonestylebackend.model.SalaEstudio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISalaEstudioRepository extends JpaRepository<SalaEstudio, Integer> {
}
