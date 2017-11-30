package all;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import todas.CargaUnica;
import todas.Usuario;
import todas.Vehiculo;

public class daoCargaUnica {
	
	public static daoCargaUnica _Instancia;
	private daoCargaUnica() {}
	public static daoCargaUnica Instancia() {
		if(_Instancia==null) {
			_Instancia = new daoCargaUnica();
		}
		return _Instancia;
	}
	
	public Boolean AsignarCargaBus(CargaUnica carga) throws Exception{
		Connection cn = Conexion.conectar();
		Boolean inserto = false;
		try {
			CallableStatement cst = cn.prepareCall("{call spAsignarCargaBus(?,?,?,?)}");
			cst.setInt(1, carga.getEncomienda().getIdEncomienda());
			cst.setInt(2, carga.getVehiculo().getIdVehiculo());
			cst.setString(3, carga.getUsuarioConductor().getNombreUsuario());
			cst.setString(4, carga.getUsuarioAlmacenero().getNombreUsuario());
			int i = cst.executeUpdate();
			if(i>0) {inserto=true;}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return inserto;
	}
	
	
	public Boolean AsignarCargaMinivan(CargaUnica carga) throws Exception{
		Connection cn = Conexion.conectar();
		Boolean inserto = false;
		try {
			CallableStatement cst = cn.prepareCall("{call spAsignarCargaDomicilio(?,?,?,?)}");
			cst.setInt(1, carga.getEncomienda().getIdEncomienda());
			cst.setInt(2, carga.getVehiculo().getIdVehiculo());
			cst.setString(3, carga.getUsuarioConductor().getNombreUsuario());
			cst.setString(4, carga.getUsuarioAlmacenero().getNombreUsuario());
			int i = cst.executeUpdate();
			if(i>0) {inserto=true;}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return inserto;
	}
	
	public ArrayList<Usuario> ListarChoferes() throws Exception{
		Connection cn = Conexion.conectar();
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		try {
			CallableStatement cst = cn.prepareCall("{call spListarChoferes()}");
			ResultSet rs = cst.executeQuery();
			while(rs.next()){
				Usuario u = new Usuario();
				u.setNombreUsuario(rs.getString("NOMBREUSUARIO"));
				lista.add(u);
			}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return lista;
	}
	
	public ArrayList<Vehiculo> ListarBuses() throws Exception{
		Connection cn = Conexion.conectar();
		ArrayList<Vehiculo> lista = new ArrayList<Vehiculo>();
		try {
			CallableStatement cst = cn.prepareCall("{call spListarBuses()}");
			ResultSet rs = cst.executeQuery();
			while(rs.next()){
				Vehiculo v = new Vehiculo();
				v.setIdVehiculo(rs.getInt("IDVEHICULO"));
				v.setNumeroPlaca(rs.getString("NUMEROPLACA"));
				lista.add(v);
			}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return lista;
	}
	
	public ArrayList<Vehiculo> ListarMinivan() throws Exception{
		Connection cn = Conexion.conectar();
		ArrayList<Vehiculo> lista = new ArrayList<Vehiculo>();
		try {
			CallableStatement cst = cn.prepareCall("{call spListarMinivan()}");
			ResultSet rs = cst.executeQuery();
			while(rs.next()){
				Vehiculo v = new Vehiculo();
				v.setIdVehiculo(rs.getInt("IDVEHICULO"));
				v.setNumeroPlaca(rs.getString("NUMEROPLACA"));
				lista.add(v);
			}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return lista;
	}

}
