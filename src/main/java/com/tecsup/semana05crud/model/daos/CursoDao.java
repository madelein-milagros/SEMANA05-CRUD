package com.tecsup.semana05crud.model.daos;

import com.tecsup.semana05crud.model.entities.Curso;

import java.util.List;

public interface CursoDao extends EntidadDao<Curso, String> {
    List<Curso> findByRangeCreditos(int min, int max);
    List<Curso> findByNombre(String nombre);
}