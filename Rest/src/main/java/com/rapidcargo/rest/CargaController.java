package com.rapidcargo.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import all.daoCargaUnica;
import todas.CargaUnica;


@Controller
public class CargaController {

	
	@RequestMapping(value = "/Carga/AsignarCargaBus", 
			method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Boolean AsignarCargaBus(@RequestBody CargaUnica carga) {
		Boolean inserto = false;
		try {			
			inserto = daoCargaUnica.Instancia().AsignarCargaBus(carga);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inserto;
	}	

	
	@RequestMapping(value = "/Carga/AsignarCargaMinivan", 
			method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Boolean AsignarCargaMinivan(@RequestBody CargaUnica carga) {
		Boolean inserto = false;
		try {			
			inserto = daoCargaUnica.Instancia().AsignarCargaMinivan(carga);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inserto;
	}

}