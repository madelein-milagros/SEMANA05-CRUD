package com.tecsup.semana05crud.model.daos;

import com.tecsup.semana05crud.model.entities.Administrador;

public interface AdministradorDao {
    Administrador validar(String user, String password);
}