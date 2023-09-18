package com.softwareproduct.gpmvsystem.domain.repository;

import com.softwareproduct.gpmvsystem.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
