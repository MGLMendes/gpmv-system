package com.softwareproduct.gpmvsystem.domain.repository;

import com.softwareproduct.gpmvsystem.domain.model.Afastamento;
import com.softwareproduct.gpmvsystem.domain.model.Beneficio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AfastamentoRepository extends JpaRepository<Afastamento, Long> {
}
