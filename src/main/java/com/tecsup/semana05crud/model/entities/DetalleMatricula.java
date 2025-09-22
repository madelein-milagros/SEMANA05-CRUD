package com.tecsup.semana05crud.model.entities;

import java.io.Serializable;

public class DetalleMatricula implements Serializable {
    private int idDetalle;
    private int idMatricula;
    private String idCurso;
    private String estado;

    public int getIdDetalle() { return idDetalle; }
    public void setIdDetalle(int idDetalle) { this.idDetalle = idDetalle; }

    public int getIdMatricula() { return idMatricula; }
    public void setIdMatricula(int idMatricula) { this.idMatricula = idMatricula; }

    public String getIdCurso() { return idCurso; }
    public void setIdCurso(String idCurso) { this.idCurso = idCurso; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
