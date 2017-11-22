package com.rapidcargo.rest;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import all.daoSucursal;
import todas.Sucursal;

@Controller
public class SucursalController {
	@RequestMapping(value = "/Sucursal/ListarSucursalGerente", method = RequestMethod.GET, 
			produces ="application/json")
		public @ResponseBody ArrayList<Sucursal> ListarSucursalGerente() {
		ArrayList<Sucursal> v = null;
		try {
			v= daoSucursal.Instancia().ListarSucursales();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return v;
	}
}
