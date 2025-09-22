package com.tecsup.semana05crud.services;

import com.tecsup.semana05crud.model.entities.Administrador;

public interface AdministradorService {
    Administrador validar(String u, String p);
}