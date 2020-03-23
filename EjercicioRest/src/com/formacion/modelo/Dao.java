package com.formacion.modelo;

import java.sql.SQLException;

public interface Dao<T> {
	public Iterable<T> obtenerTodos() throws SQLException;

	public T obtenerPorId(Long id);

	public T agregar(T t) throws SQLException;

	public T modificar(T t) throws SQLException;

	public void borrar(int id);
}
