package com.tecsup.semana05crud.model.daos;

import com.tecsup.semana05crud.model.entities.Matricula;
import java.util.List;

public interface MatriculaDao extends EntidadDao<Matricula, Integer> {
    List<Matricula> findByAlumno(String idAlumno);
}
