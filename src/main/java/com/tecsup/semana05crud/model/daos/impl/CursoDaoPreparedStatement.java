package com.tecsup.semana05crud.model.daos.impl;

import com.tecsup.semana05crud.model.daos.CursoDao;
import com.tecsup.semana05crud.model.entities.Curso;
import com.tecsup.semana05crud.util.DBConn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDaoPreparedStatement implements CursoDao {
    @Override
    public void create(Curso curso) {
        String sql = "INSERT INTO Curso (chrCurCodigo, vchCurNombre, intCurCreditos) VALUES (?, ?, ?)";
        try (Connection con = DBConn.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, curso.getCodigo());
            pst.setString(2, curso.getNombre());
            pst.setInt(3, curso.getCreditos());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en la insercion");
            e.printStackTrace();
        }
    }

    @Override
    public Curso find(String id) {
        Curso curso = null;
        String sql = "SELECT * FROM Curso WHERE chrCurCodigo = ?";
        try (Connection con = DBConn.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                curso = new Curso(
                        rs.getString("chrCurCodigo"),
                        rs.getString("vchCurNombre"),
                        rs.getInt("intCurCreditos")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error en la consulta");
            e.printStackTrace();
        }
        return curso;
    }

    @Override
    public List<Curso> findAll() {
        List<Curso> cursos = new ArrayList<>();
        String sql = "SELECT * FROM Curso";
        try (Connection con = DBConn.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                cursos.add(new Curso(
                        rs.getString("chrCurCodigo"),
                        rs.getString("vchCurNombre"),
                        rs.getInt("intCurCreditos")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error en la consulta");
            e.printStackTrace();
        }
        return cursos;
    }

    @Override
    public void update(Curso curso) {
        String sql = "UPDATE Curso SET vchCurNombre = ?, intCurCreditos = ? WHERE chrCurCodigo = ?";
        try (Connection con = DBConn.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, curso.getNombre());
            pst.setInt(2, curso.getCreditos());
            pst.setString(3, curso.getCodigo());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en la actualizacion");
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM Curso WHERE chrCurCodigo = ?";
        try (Connection con = DBConn.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en la eliminacion");
            e.printStackTrace();
        }
    }

    @Override
    public List<Curso> findByRangeCreditos(int min, int max) {
        return new ArrayList<>(); // Implementar si es necesario
    }

    @Override
    public List<Curso> findByNombre(String nombre) {
        return new ArrayList<>(); // Implementar si es necesario
    }
}