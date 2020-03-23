package com.formacion.apirest;

import java.sql.SQLException;
import java.util.TreeMap;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.formacion.entidades.Resena;
import com.formacion.modelo.Dao;
import com.formacion.modelo.DatosResenas;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(info = @Info(title = "ResenaREST", version = "1.0.0", description = "Descripción para Swagger"), servers = {
		@Server(description = "Tomcat", url = "http://localhost:8080/EjercicioRest/api/") })

@Path("/resenas")
@Produces("application/json")
@Consumes("application/json")
public class ResenaREST {
	private static final Logger LOGGER = Logger.getLogger(ResenaREST.class.getCanonicalName());

	private static TreeMap<Long, Resena> resenas = new TreeMap<>();

	@Context
	private ServletContext context;

	static {
		LOGGER.info("Generando registros de pruebas");

	}

	@GET
	public Iterable<Resena> getAll() throws SQLException {
		// System.out.println(context);
		LOGGER.info("getAll");
		LOGGER.info(context.toString());

		Dao<Resena> dao = DatosResenas.getInstancia();		
		
		return dao.obtenerTodos();
	}

	@Operation(summary = "Obtener resena por id", responses = {
			@ApiResponse(responseCode = "200", description = "Devuelve el resena cuyo id es el que se ha pedido", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Resena.class)) }),
			@ApiResponse(responseCode = "404", description = "No encontrado") })

	@GET
	@Path("/{id: \\d+}")
	public Resena getById(@PathParam("id") Long id) {
		LOGGER.info("getById(" + id + ")");
		Dao<Resena> dao = DatosResenas.getInstancia();		
		
		return dao.obtenerPorId(id);

	}

	@POST
	public Response insert(Resena resena) {
		LOGGER.info("insert(" + resena + ")");

		Dao<Resena> dao = DatosResenas.getInstancia();
		
		resena = new Resena(resena.getId(), resena.getResena(), resena.getCalificacion(), resena.getId_alumno(), resena.getId_imparticion());
			try {
				dao.agregar(resena);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return Response.status(Status.CREATED).entity(resena).build();
	}

	@PUT
	@Path("/{id: \\d+}")
	public Resena update(@PathParam("id") Long id, Resena resena) {
		LOGGER.info("update(" + id + ", " + resena + ")");

		Dao<Resena> dao = DatosResenas.getInstancia();
		
		resena = new Resena(id, resena.getResena(), resena.getCalificacion(), resena.getId_alumno(), resena.getId_imparticion());
			try {
				dao.modificar(resena);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		return resena;
	}

	@DELETE
	@Path("/{id: \\d+}")
	public String delete(@PathParam("id") Long id) {
		LOGGER.info("delete(" + id + ")");
		Dao<Resena> dao = DatosResenas.getInstancia();		
		
		dao.borrar(id);
		
		return "{}";
	}
}
