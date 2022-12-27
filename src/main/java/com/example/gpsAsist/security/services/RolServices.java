package com.example.gpsAsist.security.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.gpsAsist.security.modelo.Tipousuario;
import com.example.gpsAsist.security.repository.RolRepository;

@Service
@Transactional
public class RolServices {
    @Autowired
    RolRepository rolRepository;

    public Optional<Tipousuario> getByRolNombre(Tipousuario tipousuario) {
        return rolRepository.findByTipo(tipousuario);

    }

}
