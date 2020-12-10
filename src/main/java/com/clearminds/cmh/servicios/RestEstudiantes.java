package com.clearminds.cmh.servicios;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.clearminds.cmh.dtos.Estudiante;
import com.clearminds.cmh.excepciones.BDDException;

@Path("/estudiantes")
public class RestEstudiantes {
	
	@Path("/saludo")
	@GET
	public String saludar(){
		return "<h1>SALUDOS!!</h1>";
	}
	
	
	@Path("/insertar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void insertar(Estudiante estudiante) {
		ServicioEstudiante serv = new ServicioEstudiante();
		
		try {
			serv.insertarEstudiante(estudiante);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		System.out.println("Ingresando persona: " + estudiante);
	}
	
	@Path("/actualizar")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Estudiante actualizar(Estudiante estudiante) {
		ServicioEstudiante serv = new ServicioEstudiante();
		
		try {
			serv.abrirConexion();
			serv.actualizarEstudiante(estudiante);
		} catch (BDDException e) {
			e.printStackTrace();
		}
		
		return estudiante;
	}
}
