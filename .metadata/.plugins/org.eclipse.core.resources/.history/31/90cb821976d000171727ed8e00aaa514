package com.rapidcargo.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import all.daoEntregaUnica;


@Controller
public class EntregaUnicaController {
	
	@RequestMapping(value = "/Entrega/EntregarEnSucursal", 
			method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Boolean AsignarCargaMinivan(String idEncomienda, String nombreUsuario) {
		Boolean inserto = false;
		try {			
			inserto = daoEntregaUnica.Instancia().EntregarEnSucursal(idEncomienda,nombreUsuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inserto;
	}	
	
}
