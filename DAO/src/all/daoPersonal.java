package all;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import todas.Persona;
import todas.Personal;
import todas.TipoUsuario;
import todas.Usuario;

public class daoPersonal {
	
	public static daoPersonal _Instancia;
	private daoPersonal() {}
	public static daoPersonal Instancia() {
		if(_Instancia==null) {
			_Instancia = new daoPersonal();
		}
		return _Instancia;
	}
	
	public Boolean CrearPersonal(Personal personal, Usuario usuario) throws Exception{
		Connection cn = Conexion.conectar();
		Boolean inserto = false;
		try {
			CallableStatement cst = 
					cn.prepareCall("{call spCrearPersonal(?,?,?,?,?,?,?,?,?,?,?)}");
			cst.setString(1, personal.getDNI());
			cst.setString(2, personal.getPersona().getNombres());
			cst.setString(3, personal.getPersona().getApellidos());
			cst.setString(4, personal.getPersona().getDireccion());
			cst.setString(5, personal.getPersona().getTelefono());
			cst.setString(6, personal.getCorreoCorporativo());
			cst.setString(7, personal.getPersona().getGenero());
			cst.setString(8, usuario.getNombreUsuario());
			cst.setString(9, usuario.getContrasena());
			cst.setInt(10, usuario.getTipoUsuario().getIdTipoUsuario());
			cst.setInt(11, usuario.getSucursal().getIdSucursal());
			int i = cst.executeUpdate();
			if(i>0) {inserto=true;}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return inserto;
	}
	
	public ArrayList<Personal> ListarPersonal(String cadena) throws Exception{
		Connection cn = Conexion.conectar();
		ArrayList<Personal> lista = new ArrayList<Personal>();
		try {
			CallableStatement cst = cn.prepareCall("{call spListarPersonal(?)}");
			cst.setString(1,cadena);
			ResultSet rs = cst.executeQuery();
			while(rs.next()){
				Personal p = new Personal();
				p.setIdPersonal(rs.getInt("idPersonal"));
				
				Persona persona = new Persona();
				p.setDNI(rs.getString("DNI"));
				persona.setNombres(rs.getString("NOMBRES"));
				persona.setApellidos(rs.getString("APELLIDOS"));
				persona.setTelefono(rs.getString("TELEFONO"));
				
				p.setPersona(persona);
				
				Usuario usuario = new Usuario();
				usuario.setNombreUsuario(rs.getString("nombreUsuario"));
				usuario.setContrasena(rs.getString("contrasena"));
				
				TipoUsuario tipoUsuario = new TipoUsuario();
				tipoUsuario.setDescripcion(rs.getString("descripcion"));
				
				usuario.setTipoUsuario(tipoUsuario);
				
				p.setUsuario(usuario);
				
				lista.add(p);
			}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return lista;
	}
	
	public Boolean EliminarPersonal(String idPersonal) throws Exception{
		Connection cn = Conexion.conectar();
		Boolean elimino = false;
		try {
			CallableStatement cst = cn.prepareCall("{call spEliminarPersonal(?)}");
			cst.setString(1, idPersonal);
			int i = cst.executeUpdate();
			if(i>0) {elimino=true;}
		} catch (Exception e) { throw e;}
		finally{cn.close();}
		return elimino;
	}
}
