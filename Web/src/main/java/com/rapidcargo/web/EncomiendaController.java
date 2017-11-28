package com.rapidcargo.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import pojo.Encomienda;
import pojo.Ruta;
import pojo.Usuario;
import utiles.Constantes;

@Controller
public class EncomiendaController {
	@RequestMapping(value = "/NuevaEncomienda", method = RequestMethod.GET)
	public ModelAndView NuevaEncomienda(HttpServletRequest req) {	
		try {
			Usuario u = (Usuario)req.getSession().getAttribute("usuario");
			RestTemplate rest = new RestTemplate();
			String URI = Constantes.urlAPI + "/Ruta/ListarRutasCajero?idCiudad="+u.getSucursal().getCiudadSucursal().getIdCiudad();
			ArrayList<Ruta> lista = new ArrayList<Ruta>();
			
			ArrayList<Ruta> result = rest.getForObject(URI, lista.getClass());

			ModelAndView m = new ModelAndView("cajero/registrarEncomienda","command", new Encomienda());
			m.addObject("rutas", result);
			
			return m;
		} catch (Exception e) {
			return new ModelAndView("frmError", "error", e.getMessage());
		}
		
	}
	
	@RequestMapping(value = "/RegistrarNuevaEncomienda", method = RequestMethod.POST)
	public String VerificarAcceso(@ModelAttribute("SpringWeb")Encomienda encomienda, 
						HttpServletRequest req, ModelMap model) {		
		try {
			Boolean inserto = false;
			Usuario u = (Usuario)req.getSession().getAttribute("usuario");
			RestTemplate rest = new RestTemplate();
			String URI = Constantes.urlAPI + "/Encomienda/RegistrarEncomienda?dniCliente="+encomienda.getCliente().getDniCliente()+"&idRuta="+encomienda.getRuta().getIdRuta()+
					"&fechaLlegada="+encomienda.getFechaLlegada()+"&nombreDestinatario="+encomienda.getNombreDestinatario()+"&direccionDestinatario="+encomienda.getDescripcionEncomienda()+
					"&idSucursalOrigen="+u.getSucursal().getIdSucursal()+"&idSucursalDestino="+encomienda.getSucursalDestino().getIdSucursal()+"&usuarioCajero="+u.getNombreUsuario()+
					"&peso="+encomienda.getPeso()+"&montoPago="+encomienda.getMontoPago()+"&descripcionEncomienda="+encomienda.getDescripcionEncomienda()+"&aDomicilio="+encomienda.getaDomicilio();
			Boolean resultado = rest.getForObject(URI, inserto.getClass());
			
			if(resultado)
				return "redirect:/NuevaEncomienda?msg=Encomienda creada correctamente";
			else
				return "redirect:/NuevaEncomienda?msg=No se pudo registrar encomienda";
		
		} catch (Exception e) {
			return "error";
		}	
	}
	

	
	
}
