package all;

import java.sql.CallableStatement;
import java.sql.Connection;
import todas.Cliente;

public class daoCliente {
	
	public static daoCliente _Instancia;
	private daoCliente() {}
	public static daoCliente Instancia() {
		if(_Instancia==null) {
			_Instancia = new daoCliente();
		}
		return _Instancia;
	}
	
	public Boolean CrearCliente(Cliente cliente) throws Exception{
		Connection cn = Conexion.conectar();
		Boolean inserto = false;
		try {
			CallableStatement cst = 
					cn.prepareCall("{call spCrearCliente(?,?,?,?,?,?,?)}");
			cst.setString(1, cliente.getDniCliente());
			cst.setString(2, cliente.getPersona().getNombres());
			cst.setString(3, cliente.getPersona().getApellidos());
			cst.setString(4, cliente.getPersona().getDireccion());
			cst.setString(5, cliente.getPersona().getTelefono());
			cst.setString(6, cliente.getCorreoElectronico());
			cst.setString(7, cliente.getPersona().getGenero());
			int i = cst.executeUpdate();
			if(i>0) {inserto=true;}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return inserto;
	}
}
