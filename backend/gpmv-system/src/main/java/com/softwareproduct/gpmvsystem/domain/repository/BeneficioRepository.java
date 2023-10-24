package com.softwareproduct.gpmvsystem.domain.repository;

import com.softwareproduct.gpmvsystem.domain.model.Beneficio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficioRepository extends JpaRepository<Beneficio, Long> {
}
