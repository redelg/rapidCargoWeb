package com.rapidcargo.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import all.daoEncomienda;
import todas.Cliente;
import todas.Encomienda;
import todas.Ruta;
import todas.Sucursal;
import todas.Usuario;

@Controller
public class EncomiendaController {

	@RequestMapping(value = "/Encomienda/RegistrarEncomienda", method = RequestMethod.GET, 
			produces ="application/json")
		public @ResponseBody Boolean RegistrarEncomienda(String dniCliente,int idRuta,String fechaLlegada,String nombreDestinatario,String direccionDestinatario
				,int idSucursalOrigen,int idSucursalDestino,String usuarioCajero,float peso, float montoPago, String descripcionEncomienda, Boolean aDomicilio) {
		Boolean inserto = false;
		try {
			Encomienda encomienda = new Encomienda();
			Cliente cliente = new Cliente();
			cliente.setDniCliente(dniCliente);
			encomienda.setCliente(cliente);
			Ruta ruta = new Ruta();
			ruta.setIdRuta(idRuta);
			encomienda.setRuta(ruta);
			encomienda.setFechaLlegada(fechaLlegada);
			encomienda.setDireccionDestinatario(direccionDestinatario);
			encomienda.setNombreDestinatario(nombreDestinatario);
			
			Sucursal sucursalOrigen = new Sucursal();
			sucursalOrigen.setIdSucursal(idSucursalOrigen);
			
			Sucursal sucursalDestino = new Sucursal();
			sucursalDestino.setIdSucursal(idSucursalDestino);
			
			encomienda.setSucursalOrigen(sucursalOrigen);
			encomienda.setSucursalDestino(sucursalDestino);
			
			Usuario uCajero = new Usuario();
			uCajero.setNombreUsuario(usuarioCajero);
			
			encomienda.setUsuarioCajero(uCajero);
			
			encomienda.setPeso(peso);
			encomienda.setMontoPago(montoPago);
			encomienda.setDescripcionEncomienda(descripcionEncomienda);
			encomienda.setaDomicilio(aDomicilio);
			
			inserto = daoEncomienda.Instancia().RegistrarEncomienda(encomienda);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inserto;
	}
	
}
