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

import com.formacion.entidades.Curso;
import com.formacion.modelo.Dao;
import com.formacion.modelo.DatosCursos;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(info = @Info(title = "CursoREST", version = "1.0.0", description = "Descripción para Swagger"), servers = {
		@Server(description = "Tomcat", url = "http://localhost:8080/EjercicioRest/api/") })

@Path("/cursos")
@Produces("application/json")
@Consumes("application/json")
public class CursoREST {
	private static final Logger LOGGER = Logger.getLogger(CursoREST.class.getCanonicalName());

	private static TreeMap<Long, Curso> cursos = new TreeMap<>();

	@Context
	private ServletContext context;

	static {
		LOGGER.info("Generando registros de pruebas");


	}

	@GET
	public Iterable<Curso> getAll() throws SQLException {
		// System.out.println(context);
		LOGGER.info("getAll");
		LOGGER.info(context.toString());

		Dao<Curso> dao = DatosCursos.getInstancia();		
		
		return dao.obtenerTodos();
	}

	@Operation(summary = "Obtener curso por id", responses = {
			@ApiResponse(responseCode = "200", description = "Devuelve el curso cuyo id es el que se ha pedido", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Curso.class)) }),
			@ApiResponse(responseCode = "404", description = "No encontrado") })

	@GET
	@Path("/{id: \\d+}")
	public Curso getById(@PathParam("id") Long id) {
		LOGGER.info("getById(" + id + ")");
		Dao<Curso> dao = DatosCursos.getInstancia();		
		
		return dao.obtenerPorId(id);

	}

	@POST
	public Response insert(Curso curso) {
		LOGGER.info("insert(" + curso + ")");

		Dao<Curso> dao = DatosCursos.getInstancia();
		
		curso = new Curso(curso.getId(),curso.getNombre(),curso.getIdentificador(),curso.getNumHoras(),curso.getProfesor());
			try {
				dao.agregar(curso);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return Response.status(Status.CREATED).entity(curso).build();
	}

	@PUT
	@Path("/{id: \\d+}")
	public Curso update(@PathParam("id") Long id, Curso curso) {
		LOGGER.info("update(" + id + ", " + curso + ")");

		Dao<Curso> dao = DatosCursos.getInstancia();
		
		curso = new Curso(id,curso.getNombre(),curso.getIdentificador(),curso.getNumHoras(),curso.getProfesor());
			try {
				dao.modificar(curso);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		return curso;
	}

	@DELETE
	@Path("/{id: \\d+}")
	public String delete(@PathParam("id") Long id) {
		LOGGER.info("delete(" + id + ")");
		Dao<Curso> dao = DatosCursos.getInstancia();		
		
		dao.borrar(id);
		
		return "{}";
	}
}
