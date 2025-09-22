package com.tecsup.semana05crud.model.daos.impl;

import com.tecsup.semana05crud.model.daos.NotaDao;
import com.tecsup.semana05crud.model.entities.Nota;
import com.tecsup.semana05crud.util.DBConn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotaDaoStatement implements NotaDao {

    @Override
    public void create(Nota n) {
        String sql = "INSERT INTO Nota (idDetalle, idEvaluacion, nota) VALUES ("
                + n.getIdDetalle() + ", " + n.getIdEvaluacion() + ", " + n.getNota() + ")";
        try (Connection con = DBConn.getConnection(); Statement st = con.createStatement()) {
            st.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Nota find(Integer id) {
        Nota n = null;
        String sql = "SELECT * FROM Nota WHERE idNota=" + id;
        try (Connection con = DBConn.getConnection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            if (rs.next()) {
                n = new Nota();
                n.setIdNota(rs.getInt("idNota"));
                n.setIdDetalle(rs.getInt("idDetalle"));
                n.setIdEvaluacion(rs.getInt("idEvaluacion"));
                n.setNota(rs.getDouble("nota"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public List<Nota> findAll() {
        List<Nota> lista = new ArrayList<>();
        String sql = "SELECT * FROM Nota";
        try (Connection con = DBConn.getConnection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Nota n = new Nota();
                n.setIdNota(rs.getInt("idNota"));
                n.setIdDetalle(rs.getInt("idDetalle"));
                n.setIdEvaluacion(rs.getInt("idEvaluacion"));
                n.setNota(rs.getDouble("nota"));
                lista.add(n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void update(Nota n) {
        String sql = "UPDATE Nota SET idDetalle=" + n.getIdDetalle()
                + ", idEvaluacion=" + n.getIdEvaluacion()
                + ", nota=" + n.getNota()
                + " WHERE idNota=" + n.getIdNota();
        try (Connection con = DBConn.getConnection(); Statement st = con.createStatement()) {
            st.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM Nota WHERE idNota=" + id;
        try (Connection con = DBConn.getConnection(); Statement st = con.createStatement()) {
            st.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Nota> findByDetalle(int idDetalle) {
        List<Nota> lista = new ArrayList<>();
        String sql = "SELECT * FROM Nota WHERE idDetalle=" + idDetalle;
        try (Connection con = DBConn.getConnection(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Nota n = new Nota();
                n.setIdNota(rs.getInt("idNota"));
                n.setIdDetalle(rs.getInt("idDetalle"));
                n.setIdEvaluacion(rs.getInt("idEvaluacion"));
                n.setNota(rs.getDouble("nota"));
                lista.add(n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
