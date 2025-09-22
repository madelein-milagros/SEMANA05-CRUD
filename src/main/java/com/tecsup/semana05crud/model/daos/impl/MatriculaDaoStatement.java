package com.tecsup.semana05crud.model.daos.impl;

import com.tecsup.semana05crud.model.daos.MatriculaDao;
import com.tecsup.semana05crud.model.entities.Matricula;
import com.tecsup.semana05crud.util.DBConn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MatriculaDaoStatement implements MatriculaDao {

    @Override
    public void create(Matricula m) {
        String sql = "INSERT INTO Matricula (idAlumno, idPeriodo, fechaMatricula, estado) VALUES " +
                "('" + m.getIdAlumno() + "', " + m.getIdPeriodo() + ", '" + new java.sql.Date(m.getFechaMatricula().getTime()) + "', '" + m.getEstado() + "')";
        try (Connection con = DBConn.getConnection(); Statement st = con.createStatement()) {
            st.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Matricula find(Integer id) {
        Matricula m = null;
        String sql = "SELECT * FROM Matricula WHERE idMatricula=" + id;
        try (Connection con = DBConn.getConnection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            if (rs.next()) {
                m = new Matricula();
                m.setIdMatricula(rs.getInt("idMatricula"));
                m.setIdAlumno(rs.getString("idAlumno"));
                m.setIdPeriodo(rs.getInt("idPeriodo"));
                m.setFechaMatricula(rs.getDate("fechaMatricula"));
                m.setEstado(rs.getString("estado"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return m;
    }

    @Override
    public List<Matricula> findAll() {
        List<Matricula> lista = new ArrayList<>();
        String sql = "SELECT * FROM Matricula";
        try (Connection con = DBConn.getConnection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Matricula m = new Matricula();
                m.setIdMatricula(rs.getInt("idMatricula"));
                m.setIdAlumno(rs.getString("idAlumno"));
                m.setIdPeriodo(rs.getInt("idPeriodo"));
                m.setFechaMatricula(rs.getDate("fechaMatricula"));
                m.setEstado(rs.getString("estado"));
                lista.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void update(Matricula m) {
        String sql = "UPDATE Matricula SET idAlumno='" + m.getIdAlumno() + "', idPeriodo=" + m.getIdPeriodo() +
                ", fechaMatricula='" + new java.sql.Date(m.getFechaMatricula().getTime()) + "', estado='" + m.getEstado() +
                "' WHERE idMatricula=" + m.getIdMatricula();
        try (Connection con = DBConn.getConnection(); Statement st = con.createStatement()) {
            st.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM Matricula WHERE idMatricula=" + id;
        try (Connection con = DBConn.getConnection(); Statement st = con.createStatement()) {
            st.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Matricula> findByAlumno(String idAlumno) {
        List<Matricula> lista = new ArrayList<>();
        String sql = "SELECT * FROM Matricula WHERE idAlumno='" + idAlumno + "'";
        try (Connection con = DBConn.getConnection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Matricula m = new Matricula();
                m.setIdMatricula(rs.getInt("idMatricula"));
                m.setIdAlumno(rs.getString("idAlumno"));
                m.setIdPeriodo(rs.getInt("idPeriodo"));
                m.setFechaMatricula(rs.getDate("fechaMatricula"));
                m.setEstado(rs.getString("estado"));
                lista.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
