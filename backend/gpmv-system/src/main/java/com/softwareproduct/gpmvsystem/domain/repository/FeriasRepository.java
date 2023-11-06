package com.softwareproduct.gpmvsystem.domain.repository;

import com.softwareproduct.gpmvsystem.domain.model.Ferias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeriasRepository extends JpaRepository<Ferias, Long> {

    Optional<Ferias> findByContratadoMatricula(String matricula);
}
