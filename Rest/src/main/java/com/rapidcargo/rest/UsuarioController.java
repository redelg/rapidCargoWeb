package com.rapidcargo.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import all.daoUsuario;
import todas.Usuario;




@Controller
public class UsuarioController {
	@RequestMapping(value = "Usuario/VerificarAcceso", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Usuario VerificarAcceso(String nombreUsuario, String contrasena) {
		Usuario u = null;
		try {
			u = daoUsuario.Instancia().VerificarAcceso(nombreUsuario, contrasena);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}
	
}