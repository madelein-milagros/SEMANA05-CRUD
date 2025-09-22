package com.tecsup.semana05crud.services.impl;

import com.tecsup.semana05crud.model.daos.AdministradorDao;
import com.tecsup.semana05crud.model.daos.impl.DaoFactory;
import com.tecsup.semana05crud.model.entities.Administrador;
import com.tecsup.semana05crud.services.AdministradorService;
import com.tecsup.semana05crud.util.Util;

public class AdministradorServiceImpl implements AdministradorService {

    private AdministradorDao dao;

    public AdministradorServiceImpl() {
        // Aquí eliges si usar Statement o CallableStatement
        dao = DaoFactory.getAdministradorDao(Util.opc);
    }

    @Override
    public Administrador validar(String u, String p) {
        System.out.println("🔎 Validando usuario en DAO...");
        Administrador adm = dao.validar(u, p);
        if (adm != null) {
            System.out.println("✅ Usuario encontrado: " + adm.getLogin());
        } else {
            System.out.println("❌ Usuario o password incorrectos");
        }
        return adm;
    }
}
