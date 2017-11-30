package com.rapidcargo.rest;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import all.daoPersonal;
import todas.Persona;
import todas.Personal;
import todas.Sucursal;
import todas.TipoUsuario;
import todas.Usuario;


@Controller
public class PersonalController {
	
	@RequestMapping(value = "/Personal/CrearPersonal", method = RequestMethod.GET, 
			produces ="application/json")
		public @ResponseBody Boolean CrearPersonal(String dniPersonal, String nombresPersonal,String apellidosPersonal,String direccionPersonal,String telefono,
				String correoCorporativo,String generoPersonal, String nombreUsuario, String contrasena, int idTipoUsuario, int idSucursal) {
		Boolean inserto = false;
		try {
			Personal personal = new Personal();
			personal.setDNI(dniPersonal);
			
			Persona persona = new Persona();
			
			persona.setNombres(nombresPersonal);
			persona.setApellidos(apellidosPersonal);
			persona.setDireccion(direccionPersonal);
			persona.setTelefono(telefono);
			persona.setGenero(generoPersonal);
			
			personal.setCorreoCorporativo(correoCorporativo);
			
			personal.setPersona(persona);
			
			Usuario usuario = new Usuario();
			usuario.setNombreUsuario(nombreUsuario);
			usuario.setContrasena(contrasena);
			
			TipoUsuario tipoUsuario= new TipoUsuario();
			tipoUsuario.setIdTipoUsuario(idTipoUsuario);
			
			Sucursal sucursal = new Sucursal();
			sucursal.setIdSucursal(idSucursal);
			
			usuario.setSucursal(sucursal);
			usuario.setTipoUsuario(tipoUsuario);
			
			inserto = daoPersonal.Instancia().CrearPersonal(personal,usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inserto;
	}
	
	@RequestMapping(value = "/Personal/ListarPersonal", method = RequestMethod.GET, 
			produces ="application/json")
		public @ResponseBody ArrayList<Personal> ListarPersonal(String cadena) {
		ArrayList<Personal> p = null;
		try {
			p= daoPersonal.Instancia().ListarPersonal(cadena);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	
	@RequestMapping(value = "/Personal/EliminarPersonal", method = RequestMethod.GET, 
			produces ="application/json")
	public @ResponseBody Boolean DesactivarPersonal(String idPersonal) {
			Boolean elimino = false;
			try {
				elimino = daoPersonal.Instancia().EliminarPersonal(idPersonal);
			} catch (Exception e) {
			e.printStackTrace();
			}
			return elimino;
	}

}
