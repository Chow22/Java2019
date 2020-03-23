package com.formacion.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeMap;

import com.formacion.entidades.Resena;

 

public class DatosResenas implements Dao<Resena> {

	private TreeMap<Long, Resena> resenas = new TreeMap<>();

	private DatosResenas() {

	}

	// SINGLETON
	private final static DatosResenas INSTANCIA = new DatosResenas();

	public static DatosResenas getInstancia() {
		return INSTANCIA;
	}
	// Fin singleton

	@Override
	public Iterable<Resena> obtenerTodos() throws SQLException {
		Connection con = ConexionBD.Conexion();

		String sql = "SELECT * FROM resena;";

		Statement s = con.createStatement();

		ResultSet rs = s.executeQuery(sql);

		Long contId = 0L;
		while (rs.next()) {
			resenas.put(contId, new Resena(rs.getLong("id"), rs.getString("resena"), rs.getInt("calificacion"), rs.getInt("id_alumno"), rs.getInt("id_imparticion")));
			contId++;
		}
		return resenas.values();
	}

	@Override
	public Resena obtenerPorId(Long id) {
		Resena resena = null;
		try {
			Connection con = ConexionBD.Conexion();

			String sql = "SELECT * FROM resena WHERE id=" + id +";";

			Statement s = con.createStatement();

			ResultSet rs = s.executeQuery(sql);

			while (rs.next()) {
				resena =new Resena(rs.getLong("id"), rs.getString("resena"), rs.getInt("calificacion"), rs.getInt("id_alumno"), rs.getInt("id_imparticion"));
			}
			rs.close();
			s.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resena;
	}

	@Override
	public Resena agregar(Resena resena) throws SQLException {
		Connection con = ConexionBD.Conexion();

		String sql = "INSERT INTO resena (resena, calificacion, id_alumno,id_imparticion) VALUES (?, ?, ?,?);";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, resena.getResena());
		ps.setInt(2, resena.getCalificacion());
		ps.setInt(3, resena.getId_alumno());
		ps.setInt(4, resena.getId_imparticion());


		int numeroRegistrosModificados = ps.executeUpdate();

		if (numeroRegistrosModificados == 1) {
			System.out.println("Insertado correctamente");
		} else {
			System.err.println("No se ha insertado correctamente");
			System.err.println(numeroRegistrosModificados);
		}
		ps.close();
		con.close();
		return resena;
	}

	@Override
	public Resena modificar(Resena resena) throws SQLException {
		Connection con = ConexionBD.Conexion();

		String sql = "UPDATE resena SET  resena = ?, calificacion = ?, id_alumno=?, id_imparticion=? WHERE id = ?;";

		PreparedStatement ps = con.prepareStatement(sql);


		ps.setString(1, resena.getResena());
		ps.setInt(2, resena.getCalificacion());
		ps.setInt(3, resena.getId_alumno());
		ps.setInt(4, resena.getId_imparticion());
		
		ps.setLong(5, resena.getId());

		int numeroRegistrosModificados = ps.executeUpdate();

		if (numeroRegistrosModificados == 1) {
			System.out.println("Modificado correctamente");
		} else {
			System.err.println("No se ha modificado correctamente");
			System.err.println(numeroRegistrosModificados);
		}
		ps.close();
		con.close();
		return resena;
	}

	@Override
	public void borrar(Long id) {

		try {
			Connection con = ConexionBD.Conexion();
			String sql = "DELETE FROM resena WHERE id = ?;";
			PreparedStatement ps = con.prepareStatement(sql);
			ps = con.prepareStatement(sql);
			ps.setLong(1, id);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
