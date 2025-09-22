package com.tecsup.semana05crud.model.daos.impl;

import com.tecsup.semana05crud.model.daos.AdministradorDao;
import com.tecsup.semana05crud.model.entities.Administrador;
import com.tecsup.semana05crud.util.DBConn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdministradorDaoStatement implements AdministradorDao {

    @Override
    public Administrador validar(String user, String password) {
        Administrador administrador = null;
        String sql = "SELECT * FROM administrador " +
                "WHERE chrAdmLogin = '" + user + "' " +
                "AND chrAdmPassword = '" + password + "'";

        try (Connection con = DBConn.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            if (rs.next()) {
                administrador = new Administrador();
                administrador.setCodigo(rs.getString("chrAdmCodigo"));
                administrador.setLogin(rs.getString("chrAdmLogin"));
                administrador.setPassword(rs.getString("chrAdmPassword")); // ✅ corregido
                administrador.setNombres(rs.getString("vchAdmNombres"));
                administrador.setApellidos(rs.getString("vchAdmApellidos"));
            }

        } catch (SQLException e) {
            System.out.println("Error en validar con Statement");
            e.printStackTrace();
        }
        return administrador;
    }
}
