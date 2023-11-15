package com.softwareproduct.gpmvsystem.domain.repository;

import com.softwareproduct.gpmvsystem.domain.model.Contratado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratadoRepository extends JpaRepository<Contratado, Long> {

    @Query("select c from Contratado c where c.matricula = :matricula")
    Contratado findByMatricula(String matricula);

    Contratado findByEmail(String email);
}
