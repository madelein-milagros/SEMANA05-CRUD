package com.tecsup.semana05crud.services;

import com.tecsup.semana05crud.model.entities.Curso;

import java.util.List;

public interface CursoService {
    void grabar(Curso curso);
    Curso buscar(String id);
    List<Curso> listar();
    void actualizar(Curso curso);
    void borrar(String id);
    List<Curso> filterByCreditos(int min, int max);
}