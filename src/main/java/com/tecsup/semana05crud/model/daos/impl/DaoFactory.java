package com.tecsup.semana05crud.model.daos.impl;

import com.tecsup.semana05crud.model.daos.AdministradorDao;
import com.tecsup.semana05crud.model.daos.CursoDao;
import com.tecsup.semana05crud.util.Tipo;

public class DaoFactory {

    // Devuelve el DAO de Administrador según la opción configurada
    public static AdministradorDao getAdministradorDao(Tipo tipo) {
        switch (tipo) {
            case MEM:
                return new AdministradorDaoMemory();
            case ST:   // Statement normal
                return new AdministradorDaoStatement();
            case CST:  // CallableStatement (SP)
                return new AdministradorDaoCallableStatement();
            case PST:  // PreparedStatement
                return new AdministradorDaoPreparedStatement();
            default:
                throw new IllegalArgumentException("Tipo no soportado: " + tipo);
        }
    }

    // Devuelve el DAO de Curso según la opción configurada
    public static CursoDao getCursoDao(Tipo tipo) {
        switch (tipo) {
            case MEM:
                return new CursoDaoMemory();
            case ST:
                return new CursoDaoStatement();
            case CST:
                return new CursoDaoCallableStatement();
            case PST:
                return new CursoDaoPreparedStatement();
            default:
                throw new IllegalArgumentException("Tipo no soportado: " + tipo);
        }
    }
}
