package all;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import todas.Cliente;
import todas.Encomienda;
import todas.EstadoEncomienda;
import todas.Persona;
import todas.Sucursal;

public class daoEncomienda {

	public static daoEncomienda _Instancia;
	private daoEncomienda() {}
	public static daoEncomienda Instancia() {
		if(_Instancia==null) {
			_Instancia = new daoEncomienda();
		}
		return _Instancia;
	}
	
	public Boolean RegistrarEncomienda(Encomienda encomienda) throws Exception{
		Connection cn = Conexion.conectar();
		Boolean inserto = false;
		SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
		String fechaLlegada = myFormat.format(fromUser.parse(encomienda.getFechaLlegada()));
		try {
			CallableStatement cst = 
					cn.prepareCall("{call spRegistrarEncomienda(?,?,?,?,?,?,?,?,?,?,?,?)}");
			cst.setString(1, encomienda.getCliente().getDniCliente());
			cst.setInt(2, encomienda.getRuta().getIdRuta());
			cst.setString(3, fechaLlegada);
			cst.setString(4, encomienda.getNombreDestinatario());
			cst.setString(5, encomienda.getDireccionDestinatario());
			cst.setInt(6,encomienda.getSucursalOrigen().getIdSucursal());
			cst.setInt(7,encomienda.getSucursalDestino().getIdSucursal());
			cst.setString(8,encomienda.getUsuarioCajero().getNombreUsuario());
			cst.setFloat(9,encomienda.getPeso());
			cst.setFloat(10,encomienda.getMontoPago());
			cst.setString(11,encomienda.getDescripcionEncomienda());
			cst.setBoolean(12,encomienda.getaDomicilio());
			int i = cst.executeUpdate();
			if(i>0) {inserto=true;}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return inserto;
	}
	
	public ArrayList<Encomienda> ListarEncomiendasSalir(int idSucursalOrigen) throws Exception{
		Connection cn = Conexion.conectar();
		ArrayList<Encomienda> lista = new ArrayList<Encomienda>();
		try {
			CallableStatement cst = cn.prepareCall("{call spListarEncomiendasSalida (?)}");
			cst.setInt(1,idSucursalOrigen);
			ResultSet rs = cst.executeQuery();
			while(rs.next()){
				
				Encomienda e = new Encomienda();
				e.setIdEncomienda(rs.getInt("IDENCOMIENDA"));
				e.setPeso(rs.getFloat("PESO"));
				e.setFechaLlegada(rs.getString("FECHALLEGADA"));
				
				Sucursal s = new Sucursal();
				s.setNombreAgencia(rs.getString("NOMBREAGENCIA"));
				e.setSucursalOrigen(s);
					
				EstadoEncomienda ee = new EstadoEncomienda();
				ee.setDescripcionEstadoEncomienda(rs.getString("DESCRIPCIONESTADO"));
				e.setEstadoEncomienda(ee);
				
				lista.add(e);
			}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return lista;
	}
	
	public ArrayList<Encomienda> ListarEncomiendasEntregaSucursal(int idSucursalOrigen) throws Exception{
		Connection cn = Conexion.conectar();
		ArrayList<Encomienda> lista = new ArrayList<Encomienda>();
		try {
			CallableStatement cst = cn.prepareCall("{call spListarEncomiendasEntregaSucursal (?)}");
			cst.setInt(1,idSucursalOrigen);
			ResultSet rs = cst.executeQuery();
			while(rs.next()){
				
				Encomienda e = new Encomienda();
				e.setCodigoEncomienda(rs.getString("CODIGOENCOMIENDA"));
				e.setIdEncomienda(rs.getInt("IDENCOMIENDA"));
				e.setNombreDestinatario(rs.getString("NOMBREDESTINATARIO"));
				e.setDireccionDestinatario(rs.getString("DIRECCIONDESTINATARIO"));
				e.setFechaLlegada(rs.getString("FECHALLEGADA"));
				
				EstadoEncomienda ee = new EstadoEncomienda();
				ee.setDescripcionEstadoEncomienda(rs.getString("DESCRIPCIONESTADO"));
				e.setEstadoEncomienda(ee);
				
				Cliente c = new Cliente();
				Persona p = new Persona();
				p.setNombres(rs.getString("NOMBRES"));
				p.setApellidos(rs.getString("APELLIDOS"));
				c.setPersona(p);
				e.setCliente(c);
				
				lista.add(e);
			}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return lista;
	}
	
	public ArrayList<Encomienda> ListarEncomiendasEntregaDomicilio(int idSucursalOrigen) throws Exception{
		Connection cn = Conexion.conectar();
		ArrayList<Encomienda> lista = new ArrayList<Encomienda>();
		try {
			CallableStatement cst = cn.prepareCall("{call spListarEncomiendasEntregaDomicilio (?)}");
			cst.setInt(1,idSucursalOrigen);
			ResultSet rs = cst.executeQuery();
			while(rs.next()){
				
				Encomienda e = new Encomienda();
				e.setIdEncomienda(rs.getInt("IDENCOMIENDA"));
				e.setNombreDestinatario(rs.getString("NOMBREDESTINATARIO"));
				e.setDireccionDestinatario(rs.getString("DIRECCIONDESTINATARIO"));
				e.setFechaLlegada(rs.getString("FECHALLEGADA"));
				
				EstadoEncomienda ee = new EstadoEncomienda();
				ee.setDescripcionEstadoEncomienda(rs.getString("DESCRIPCIONESTADO"));
				e.setEstadoEncomienda(ee);
				
				lista.add(e);
			}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return lista;
	}
	
}