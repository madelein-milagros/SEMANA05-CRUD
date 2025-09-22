package com.tecsup.semana05crud.model.daos.impl;

import com.tecsup.semana05crud.model.daos.AdministradorDao;
import com.tecsup.semana05crud.model.entities.Administrador;
import com.tecsup.semana05crud.util.DBConn;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdministradorDaoCallableStatement implements AdministradorDao {

    @Override
    public Administrador validar(String user, String password) {
        Administrador administrador = null;

        String sql = "{call sp_login(?,?)}";

        try (Connection con = DBConn.getConnection();
             CallableStatement cst = con.prepareCall(sql)) {

            cst.setString(1, user);
            cst.setString(2, password);

            try (ResultSet rs = cst.executeQuery()) {
                if (rs.next()) {
                    administrador = new Administrador();
                    administrador.setCodigo(rs.getString("chrAdmCodigo"));
                    administrador.setLogin(rs.getString("chrAdmLogin"));
                    administrador.setPassword(rs.getString("chrAdmPassword"));
                    administrador.setNombres(rs.getString("vchAdmNombres"));
                    administrador.setApellidos(rs.getString("vchAdmApellidos"));
                }
            }

        } catch (SQLException e) {
            System.out.println("Error en validar con CallableStatement");
            e.printStackTrace();
        }

        return administrador;
    }
}
