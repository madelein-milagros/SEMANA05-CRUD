package com.tecsup.semana05crud.model.daos.impl;

import com.tecsup.semana05crud.model.daos.AdministradorDao;
import com.tecsup.semana05crud.model.entities.Administrador;

public class AdministradorDaoMemory implements AdministradorDao {
    @Override
    public Administrador validar(String u, String p) {
        Administrador administrador = null;
        if (u.equals("admin") && p.equals("admin")) {
            administrador = new Administrador();
            administrador.setNombres("juan");
            administrador.setApellidos("perez");
        }
        return administrador;
    }
}