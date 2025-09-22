package com.tecsup.semana05crud.model.entities;

import java.io.Serializable;

public class Evaluacion implements Serializable {
    private int idEvaluacion;
    private String idCurso;
    private String nombre;
    private double peso;

    public int getIdEvaluacion() { return idEvaluacion; }
    public void setIdEvaluacion(int idEvaluacion) { this.idEvaluacion = idEvaluacion; }

    public String getIdCurso() { return idCurso; }
    public void setIdCurso(String idCurso) { this.idCurso = idCurso; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }
}
