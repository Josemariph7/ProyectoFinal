package controller;

import java.util.List;

/**
 * Interfaz genérica para operaciones CRUD.
 * @param <E> Tipo de entidad.
 */
public interface CRUD<E> {

    List<E> getAll();

    E getById(Long id);

    boolean create(E entity);

    boolean update(E entity);

    boolean delete(Long id);
}
