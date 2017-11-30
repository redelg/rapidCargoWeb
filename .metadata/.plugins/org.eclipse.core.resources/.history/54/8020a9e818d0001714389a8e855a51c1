package all;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.text.SimpleDateFormat;

import todas.Encomienda;

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
	
}
