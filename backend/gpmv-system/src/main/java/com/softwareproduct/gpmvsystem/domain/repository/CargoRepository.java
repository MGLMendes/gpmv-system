package com.softwareproduct.gpmvsystem.domain.repository;

import com.softwareproduct.gpmvsystem.domain.model.Cargos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<Cargos, Long> {
}
