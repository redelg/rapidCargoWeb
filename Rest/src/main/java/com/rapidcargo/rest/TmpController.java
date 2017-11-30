package com.rapidcargo.rest;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import all.daoTmp;
import todas.Tmp;

public class TmpController {
	
	@RequestMapping(value = "/Tmp/ListarRutasPorEncomienda", method = RequestMethod.GET, 
			produces ="application/json")
		public @ResponseBody ArrayList<Tmp> ListarRutasPorEncomienda() {
		ArrayList<Tmp> t = null;
		try {
			t= daoTmp.Instancia().ListarRutasPorEncomienda();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
}

