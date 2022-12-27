package com.example.gpsAsist.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gpsAsist.security.modelo.Tipousuario;

@Repository
public interface RolRepository extends JpaRepository<Tipousuario, Integer> {
    Optional<Tipousuario> findByTipo(Tipousuario tipousuario);

}
