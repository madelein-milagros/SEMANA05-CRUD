package com.tecsup.semana05crud.model.daos;

import com.tecsup.semana05crud.model.entities.Asistencia;
import java.util.List;

public interface AsistenciaDao extends EntidadDao<Asistencia, Integer> {
    List<Asistencia> findBySesion(int idSesion);
    List<Asistencia> findByDetalle(int idDetalle);
}
