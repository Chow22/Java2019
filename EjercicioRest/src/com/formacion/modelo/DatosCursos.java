package com.formacion.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeMap;

import com.formacion.entidades.Curso;

 

public class DatosCursos implements Dao<Curso> {

	private TreeMap<Long, Curso> cursos = new TreeMap<>();

	private DatosCursos() {

	}

	// SINGLETON
	private final static DatosCursos INSTANCIA = new DatosCursos();

	public static DatosCursos getInstancia() {
		return INSTANCIA;
	}
	// Fin singleton

	@Override
	public Iterable<Curso> obtenerTodos() throws SQLException {
		Connection con = ConexionBD.Conexion();

		String sql = "SELECT c.codigo,c.nombre,c.identificador,c.nHoras,CONCAT(p.nombre,\" \",p.apellidos) as profesor FROM curso c JOIN profesor p ON c.profesor_codigo=p.codigo";

		Statement s = con.createStatement();

		ResultSet rs = s.executeQuery(sql);

		Long contId = 0L;
		while (rs.next()) {
			cursos.put(contId, new Curso(rs.getLong("codigo"), rs.getString("nombre"), rs.getString("identificador"), rs.getInt("nHoras"), rs.getString("profesor")));
			contId++;
		}
		return cursos.values();
	}

	@Override
	public Curso obtenerPorId(int id) {
		Curso curso = null;
		try {
			Connection con = ConexionBD.Conexion();

			String sql = "SELECT * FROM cursos where id=" + id;

			Statement s = con.createStatement();

			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				curso =new Curso(rs.getLong("id"), rs.getString("nombre"), rs.getString("identificador"), rs.getInt("nHoras"), rs.getString("profesor"));
			}
			rs.close();
			s.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return curso;
	}

	@Override
	public Curso agregar(Curso curso) throws SQLException {
		Connection con = ConexionBD.Conexion();

		String sql = "INSERT INTO curso (nombre, identificador, nhoras,profesor_codigo) VALUES (?, ?, ?,?)";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, curso.getNombre());
		ps.setString(2, curso.getIdentificador());
		ps.setInt(3, curso.getNumHoras());
		ps.setString(4, curso.getProfesor());


		int numeroRegistrosModificados = ps.executeUpdate();

		if (numeroRegistrosModificados == 1) {
			System.out.println("Insertado correctamente");
		} else {
			System.err.println("No se ha insertado correctamente");
			System.err.println(numeroRegistrosModificados);
		}
		ps.close();
		con.close();
		return curso;
	}

	@Override
	public Curso modificar(Curso curso) throws SQLException {
		Connection con = ConexionBD.Conexion();

		String sql = "UPDATE cursos SET nombre = ?, apellidos = ?, dni = ? WHERE id = ?";

		PreparedStatement ps = con.prepareStatement(sql);


		ps.setString(1, curso.getNombre());
		ps.setString(2, curso.getIdentificador());
		ps.setInt(3, curso.getNumHoras());
		ps.setString(4, curso.getProfesor());

		
		ps.setLong(5, curso.getId());

		int numeroRegistrosModificados = ps.executeUpdate();

		if (numeroRegistrosModificados == 1) {
			System.out.println("Modificado correctamente");
		} else {
			System.err.println("No se ha modificado correctamente");
			System.err.println(numeroRegistrosModificados);
		}
		ps.close();
		con.close();
		return curso;
	}

	@Override
	public void borrar(int id) {

		try {
			Connection con = ConexionBD.Conexion();
			String sql = "DELETE FROM cursos WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
