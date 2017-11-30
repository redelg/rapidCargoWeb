package com.rapidcargo.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "principalExtranet";
	}
	
	
	@RequestMapping(value = "/principalCajero", method = RequestMethod.GET)
	public String principalCajero(Model model) {
		return "cajero/principalCajero";
	}
	
	
	@RequestMapping(value = "/principalAlmacen", method = RequestMethod.GET)
	public String principalAlmacen(Model model) {
		return "almacen/principalAlmacen";
	}
	
	
}
