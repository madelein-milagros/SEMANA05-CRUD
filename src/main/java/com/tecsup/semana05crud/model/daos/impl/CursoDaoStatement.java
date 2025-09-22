package com.tecsup.semana05crud.model.daos.impl;

import com.tecsup.semana05crud.model.daos.CursoDao;
import com.tecsup.semana05crud.model.entities.Curso;
import com.tecsup.semana05crud.util.DBConn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CursoDaoStatement implements CursoDao {

    @Override
    public void create(Curso curso) {
        String sql = "INSERT INTO Curso (chrCurCodigo, vchCurNombre, intCurCreditos) " +
                "VALUES ('" + curso.getCodigo() + "', '" + curso.getNombre() + "', " + curso.getCreditos() + ")";
        try (Connection con = DBConn.getConnection();
             Statement st = con.createStatement()) {
            st.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Error en la inserción con Statement");
            e.printStackTrace();
        }
    }

    @Override
    public Curso find(String id) {
        Curso curso = null;
        String sql = "SELECT * FROM Curso WHERE chrCurCodigo = '" + id + "'";
        try (Connection con = DBConn.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            if (rs.next()) {
                curso = new Curso(
                        rs.getString("chrCurCodigo"),
                        rs.getString("vchCurNombre"),
                        rs.getInt("intCurCreditos")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error en la consulta con Statement");
            e.printStackTrace();
        }
        return curso;
    }

    @Override
    public List<Curso> findAll() {
        List<Curso> cursos = new ArrayList<>();
        String sql = "SELECT * FROM Curso";
        try (Connection con = DBConn.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                cursos.add(new Curso(
                        rs.getString("chrCurCodigo"),
                        rs.getString("vchCurNombre"),
                        rs.getInt("intCurCreditos")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error en findAll con Statement");
            e.printStackTrace();
        }
        return cursos;
    }

    @Override
    public void update(Curso curso) {
        String sql = "UPDATE Curso SET vchCurNombre = '" + curso.getNombre() +
                "', intCurCreditos = " + curso.getCreditos() +
                " WHERE chrCurCodigo = '" + curso.getCodigo() + "'";
        try (Connection con = DBConn.getConnection();
             Statement st = con.createStatement()) {
            st.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Error en la actualización con Statement");
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM Curso WHERE chrCurCodigo = '" + id + "'";
        try (Connection con = DBConn.getConnection();
             Statement st = con.createStatement()) {
            st.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Error en la eliminación con Statement");
            e.printStackTrace();
        }
    }

    @Override
    public List<Curso> findByRangeCreditos(int min, int max) {
        List<Curso> cursos = new ArrayList<>();
        String sql = "SELECT * FROM Curso WHERE intCurCreditos BETWEEN " + min + " AND " + max;
        try (Connection con = DBConn.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                cursos.add(new Curso(
                        rs.getString("chrCurCodigo"),
                        rs.getString("vchCurNombre"),
                        rs.getInt("intCurCreditos")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error en findByRangeCreditos con Statement");
            e.printStackTrace();
        }
        return cursos;
    }

    @Override
    public List<Curso> findByNombre(String nombre) {
        List<Curso> cursos = new ArrayList<>();
        String sql = "SELECT * FROM Curso WHERE vchCurNombre LIKE '%" + nombre + "%'";
        try (Connection con = DBConn.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                cursos.add(new Curso(
                        rs.getString("chrCurCodigo"),
                        rs.getString("vchCurNombre"),
                        rs.getInt("intCurCreditos")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error en findByNombre con Statement");
            e.printStackTrace();
        }
        return cursos;
    }
}
