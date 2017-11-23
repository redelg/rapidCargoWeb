package all;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import todas.Sucursal;

public class daoSucursal {
	
	public static daoSucursal  _Instancia;
	private daoSucursal() {}
	public static daoSucursal Instancia() {
		if(_Instancia==null) {
			_Instancia = new daoSucursal();
		}
		return _Instancia;
	}
	
	
	public ArrayList<Sucursal> ListarSucursales() throws Exception{
		Connection cn = Conexion.conectar();
		ArrayList<Sucursal> lista = new ArrayList<Sucursal>();
		try {
			CallableStatement cst = cn.prepareCall("{call spListarSucursalGerente()}");
			ResultSet rs = cst.executeQuery();
			while(rs.next()){
				Sucursal s = new Sucursal();
				s.setIdSucursal(rs.getInt("IDSUCURSAL"));
				s.setNombreAgencia(rs.getString("NOMBREAGENCIA"));
				lista.add(s);
			}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return lista;
	}
}
