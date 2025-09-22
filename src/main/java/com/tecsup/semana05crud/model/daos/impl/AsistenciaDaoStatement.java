package com.tecsup.semana05crud.model.daos.impl;

import com.tecsup.semana05crud.model.daos.AsistenciaDao;
import com.tecsup.semana05crud.model.entities.Asistencia;
import com.tecsup.semana05crud.util.DBConn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AsistenciaDaoStatement implements AsistenciaDao {

    @Override
    public void create(Asistencia a) {
        String sql = "INSERT INTO Asistencia (idSesion, idDetalle, estado) VALUES ("
                + a.getIdSesion() + ", " + a.getIdDetalle() + ", '" + a.getEstado() + "')";
        try (Connection con = DBConn.getConnection(); Statement st = con.createStatement()) {
            st.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Asistencia find(Integer id) {
        Asistencia a = null;
        String sql = "SELECT * FROM Asistencia WHERE idAsistencia=" + id;
        try (Connection con = DBConn.getConnection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            if (rs.next()) {
                a = new Asistencia();
                a.setIdAsistencia(rs.getInt("idAsistencia"));
                a.setIdSesion(rs.getInt("idSesion"));
                a.setIdDetalle(rs.getInt("idDetalle"));
                a.setEstado(rs.getString("estado"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    @Override
    public List<Asistencia> findAll() {
        List<Asistencia> lista = new ArrayList<>();
        String sql = "SELECT * FROM Asistencia";
        try (Connection con = DBConn.getConnection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Asistencia a = new Asistencia();
                a.setIdAsistencia(rs.getInt("idAsistencia"));
                a.setIdSesion(rs.getInt("idSesion"));
                a.setIdDetalle(rs.getInt("idDetalle"));
                a.setEstado(rs.getString("estado"));
                lista.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void update(Asistencia a) {
        String sql = "UPDATE Asistencia SET idSesion=" + a.getIdSesion()
                + ", idDetalle=" + a.getIdDetalle()
                + ", estado='" + a.getEstado()
                + "' WHERE idAsistencia=" + a.getIdAsistencia();
        try (Connection con = DBConn.getConnection(); Statement st = con.createStatement()) {
            st.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM Asistencia WHERE idAsistencia=" + id;
        try (Connection con = DBConn.getConnection(); Statement st = con.createStatement()) {
            st.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Asistencia> findBySesion(int idSesion) {
        List<Asistencia> lista = new ArrayList<>();
        String sql = "SELECT * FROM Asistencia WHERE idSesion=" + idSesion;
        try (Connection con = DBConn.getConnection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Asistencia a = new Asistencia();
                a.setIdAsistencia(rs.getInt("idAsistencia"));
                a.setIdSesion(rs.getInt("idSesion"));
                a.setIdDetalle(rs.getInt("idDetalle"));
                a.setEstado(rs.getString("estado"));
                lista.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public List<Asistencia> findByDetalle(int idDetalle) {
        List<Asistencia> lista = new ArrayList<>();
        String sql = "SELECT * FROM Asistencia WHERE idDetalle=" + idDetalle;
        try (Connection con = DBConn.getConnection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Asistencia a = new Asistencia();
                a.setIdAsistencia(rs.getInt("idAsistencia"));
                a.setIdSesion(rs.getInt("idSesion"));
                a.setIdDetalle(rs.getInt("idDetalle"));
                a.setEstado(rs.getString("estado"));
                lista.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
