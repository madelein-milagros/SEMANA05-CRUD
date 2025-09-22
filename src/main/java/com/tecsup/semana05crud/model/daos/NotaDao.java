package com.tecsup.semana05crud.model.daos;

import com.tecsup.semana05crud.model.entities.Nota;
import java.util.List;

public interface NotaDao extends EntidadDao<Nota, Integer> {
    List<Nota> findByDetalle(int idDetalle);
}
