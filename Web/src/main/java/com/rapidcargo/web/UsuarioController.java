package com.rapidcargo.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import pojo.Usuario;
import utiles.Constantes;

@Controller
public class UsuarioController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView Login() {		
		return new ModelAndView("loginIntranet", "command", new Usuario());	
	}
	
	@RequestMapping(value = "/VerificarAcceso", method = RequestMethod.POST)
	public String VerificarAcceso(@ModelAttribute("SpringWeb")Usuario u, 
						HttpServletRequest req, ModelMap model) {		
		try {
			String Usuario = u.getNombreUsuario();
			String Password = u.getContrasena();
			//Verficamos acceso desde la API REST
			RestTemplate rest = new RestTemplate();
			String URI = Constantes.urlAPI+"/Usuario/VerificarAcceso" + 
						"?nombreUsuario="+Usuario+"&contrasena="+Password;
			Usuario result = rest.getForObject(URI, u.getClass());
			if(result!=null) {
				//agregamos el usuario logueado a la sesion 
				if(result.getTipoUsuario().getIdTipoUsuario() == 2)
					{	
						req.getSession().setAttribute("usuario", result);
						return "redirect:/principalCajero";	
					}
				else if (result.getTipoUsuario().getIdTipoUsuario() == 3)
					{
						req.getSession().setAttribute("usuario", result);
						return "redirect:/principalAlmacen";	
					}
				else
					return "redirect:/login?msg=Tipo de Usuario Incorrecto";
			}else {
				return "redirect:/login?msg=Usuario o password no valido";
			}			
		} catch (Exception e) {
			return "error";
		}	
	}
	
}