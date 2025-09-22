package com.tecsup.semana05crud.model.entities;

import java.io.Serializable;
import java.util.Date;

public class Matricula implements Serializable {
    private int idMatricula;
    private String idAlumno;
    private int idPeriodo;
    private Date fechaMatricula;
    private String estado;

    public Matricula() {}

    public Matricula(int idMatricula, String idAlumno, int idPeriodo, Date fechaMatricula, String estado) {
        this.idMatricula = idMatricula;
        this.idAlumno = idAlumno;
        this.idPeriodo = idPeriodo;
        this.fechaMatricula = fechaMatricula;
        this.estado = estado;
    }

    public int getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

    public String getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(int idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public Date getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(Date fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Matricula{" +
                "idMatricula=" + idMatricula +
                ", idAlumno='" + idAlumno + '\'' +
                ", idPeriodo=" + idPeriodo +
                ", fechaMatricula=" + fechaMatricula +
                ", estado='" + estado + '\'' +
                '}';
    }
}
