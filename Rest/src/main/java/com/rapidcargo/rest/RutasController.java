package com.rapidcargo.rest;


import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import all.daoRuta;
import todas.Ciudad;
import todas.Ruta;

@Controller
public class RutasController {
	
	@RequestMapping(value = "/Ruta/CrearRuta", method = RequestMethod.GET, 
			produces ="application/json")
		public @ResponseBody Boolean CrearRuta(String nombreRuta, int idCiudadOrigen,int idCiudadDestino,String descripcionRuta) {
		Boolean inserto = false;
		try {
			todas.Ruta ruta = new Ruta();
			ruta.setNombreRuta(nombreRuta);
			
			todas.Ciudad ciudadOrigen = new Ciudad();
			ciudadOrigen.setIdCiudad(idCiudadOrigen);
			
			todas.Ciudad ciudadDestino = new Ciudad();
			ciudadDestino.setIdCiudad(idCiudadDestino);
			
			ruta.setCiudadOrigen(ciudadOrigen);
			ruta.setCiudadDestino(ciudadDestino);
			
			ruta.setDescripcionRuta(descripcionRuta);
			
			inserto = daoRuta.Instancia().CrearRuta(ruta);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inserto;
	}
	
	@RequestMapping(value = "/Ruta/ListarRutasGerente", method = RequestMethod.GET, 
			produces ="application/json")
		public @ResponseBody ArrayList<Ruta> ListarRutasGerente(String cadena) {
		ArrayList<todas.Ruta> r = null;
		try {
			
			r= daoRuta.Instancia().ListarRutasGerente(cadena);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}
	
	@RequestMapping(value = "/Ruta/EliminarRuta", method = RequestMethod.GET, 
			produces ="application/json")
	public @ResponseBody Boolean DesactivarRuta(String idRuta) {
			Boolean elimino = false;
			try {
				elimino = daoRuta.Instancia().EliminarRuta(idRuta);
			} catch (Exception e) {
			e.printStackTrace();
			}
			return elimino;
	}
}
