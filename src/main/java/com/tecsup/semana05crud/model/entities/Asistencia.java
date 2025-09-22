package com.tecsup.semana05crud.model.entities;

import java.io.Serializable;

public class Asistencia implements Serializable {
    private int idAsistencia;
    private int idSesion;
    private int idDetalle;
    private String estado; // asistió, tardanza, falta, justificada

    public Asistencia() {}

    public Asistencia(int idAsistencia, int idSesion, int idDetalle, String estado) {
        this.idAsistencia = idAsistencia;
        this.idSesion = idSesion;
        this.idDetalle = idDetalle;
        this.estado = estado;
    }

    public int getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(int idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public int getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(int idSesion) {
        this.idSesion = idSesion;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Asistencia{" +
                "idAsistencia=" + idAsistencia +
                ", idSesion=" + idSesion +
                ", idDetalle=" + idDetalle +
                ", estado='" + estado + '\'' +
                '}';
    }
}
