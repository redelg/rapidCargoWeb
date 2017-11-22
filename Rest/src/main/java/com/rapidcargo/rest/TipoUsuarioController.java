package com.rapidcargo.rest;

import java.util.ArrayList;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import all.daoTipoUsuario;
import todas.TipoUsuario;

@Controller
public class TipoUsuarioController {
	@RequestMapping(value = "/TipoUsuario/ListarTipoUsuario", method = RequestMethod.GET, 
			produces ="application/json")
		public @ResponseBody ArrayList<TipoUsuario> ListarTipoUsuario() {
		ArrayList<TipoUsuario> tu = null;
		try {
			tu= daoTipoUsuario.Instancia().ListarTipoUsuario();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tu;
	}
}

