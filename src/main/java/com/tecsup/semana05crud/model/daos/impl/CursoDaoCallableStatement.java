package com.tecsup.semana05crud.model.daos.impl;

import com.tecsup.semana05crud.model.daos.CursoDao;
import com.tecsup.semana05crud.model.entities.Curso;
import com.tecsup.semana05crud.util.DBConn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDaoCallableStatement implements CursoDao {

    @Override
    public void create(Curso curso) {
        String sql = "{ call sp_ins_curso(?, ?, ?) }";
        try (Connection con = DBConn.getConnection();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setString(1, curso.getCodigo());
            cs.setString(2, curso.getNombre());
            cs.setInt(3, curso.getCreditos());
            cs.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en insertar curso (CST)");
            e.printStackTrace();
        }
    }

    @Override
    public Curso find(String id) {
        Curso curso = null;
        String sql = "{ call sp_find_curso(?) }";
        try (Connection con = DBConn.getConnection();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setString(1, id);
            try (ResultSet rs = cs.executeQuery()) {
                if (rs.next()) {
                    curso = new Curso(
                            rs.getString("chrCurCodigo"),
                            rs.getString("vchCurNombre"),
                            rs.getInt("intCurCreditos")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en buscar curso (CST)");
            e.printStackTrace();
        }
        return curso;
    }

    @Override
    public List<Curso> findAll() {
        List<Curso> cursos = new ArrayList<>();
        String sql = "{ call sp_findAll_curso() }";
        try (Connection con = DBConn.getConnection();
             CallableStatement cs = con.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {
            while (rs.next()) {
                cursos.add(new Curso(
                        rs.getString("chrCurCodigo"),
                        rs.getString("vchCurNombre"),
                        rs.getInt("intCurCreditos")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error en listar cursos (CST)");
            e.printStackTrace();
        }
        return cursos;
    }

    @Override
    public void update(Curso curso) {
        String sql = "{ call sp_upd_curso(?, ?, ?) }";
        try (Connection con = DBConn.getConnection();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setString(1, curso.getCodigo());
            cs.setString(2, curso.getNombre());
            cs.setInt(3, curso.getCreditos());
            cs.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en actualizar curso (CST)");
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        String sql = "{ call sp_del_curso(?) }";
        try (Connection con = DBConn.getConnection();
             CallableStatement cs = con.prepareCall(sql)) {
            cs.setString(1, id);
            cs.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en eliminar curso (CST)");
            e.printStackTrace();
        }
    }

    @Override
    public List<Curso> findByRangeCreditos(int min, int max) {
        // No tienes SP para esto, así que lo dejamos vacío
        return new ArrayList<>();
    }

    @Override
    public List<Curso> findByNombre(String nombre) {
        // No tienes SP para esto, así que lo dejamos vacío
        return new ArrayList<>();
    }
}
