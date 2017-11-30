package com.rapidcargo.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import pojo.Cliente;
import utiles.Constantes;

@Controller
public class ClienteController {
	
	@RequestMapping(value = "/NuevoCliente", method = RequestMethod.GET)
	public ModelAndView NuevoCliente(HttpServletRequest req) {	
		try {
			ModelAndView m = new ModelAndView("cajero/registrarCliente","command", new Cliente());
	  	    return m;
		} catch (Exception e) {
			return new ModelAndView("frmError", "error", e.getMessage());
		}
		
	}

	@RequestMapping(value = "/CrearCliente", method = RequestMethod.POST)
	public String CrearCliente(@ModelAttribute("SpringWeb")Cliente cliente, 
						HttpServletRequest req, ModelMap model) {		
		try {
			Boolean inserto = false;
			
			RestTemplate rest = new RestTemplate();
			String URI = Constantes.urlAPI + "/Cliente/CrearCliente?dniCliente="+cliente.getDniCliente()+"&nombresCliente="+cliente.getPersona().getNombres()+"&apellidosCliente="+
			cliente.getPersona().getApellidos()+"&direccionCliente="+cliente.getPersona().getDireccion()+"&telefonoCliente="+cliente.getPersona().getTelefono()+"&correoElectronico="+
					cliente.getCorreoElectronico()+"&generoCliente="+cliente.getPersona().getGenero();
			Boolean resultado = rest.getForObject(URI, inserto.getClass());
			
			if(resultado)
				return "redirect:/principalCajero?msg=Cliente creado correctamente";
			else
				return "redirect:/principalCajero?msg=No se pudo Crear el Cliente";
		
		} catch (Exception e) {
			return "error";
		}	
	}
}
